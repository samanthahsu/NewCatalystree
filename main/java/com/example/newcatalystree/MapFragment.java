package com.example.newcatalystree;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newcatalystree.LocalDatabase.MapTile;

import java.util.List;

@SuppressLint("NewApi")

public class MapFragment extends Fragment {

    //    declare int for board site
    final static int maxN = 25;
    Context context;

    //    declare for imageView (Cells) array
    private ImageView[][] ivCell = new ImageView[maxN][maxN];

//    create corresponding drawable resources to numbers
    private Drawable[] drawCell = new Drawable[4];


    private LinearLayout linBoardGame;
    private TextView beadDisplay;

    private OnFragmentInteractionListener mListener;

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        todo use layered drawables in the image views instead of normal drawables to allow for growing brush, creatures, and secrets
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        context = getContext();

//        upper corner menu
        beadDisplay = view.findViewById(R.id.tv_bead_display);
        UpdateBeadDisplay();
        Button btEdit = view.findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditFragment();
            }
        });

        linBoardGame = view.findViewById(R.id.linBoardGame);
        loadDrawableResources();
        initializeMap(); // fill with sky

        populateDatabase();

//        Update image view using database

        UpdateMap();

        return view;
    }

//        Update image view using database
    private void UpdateMap() {

        List<MapTile> map = MainAppActivity.myAppDatabase.myDao().getMap();

        for(MapTile mapTile : map) {

            int x = mapTile.getX_coordinate();
            int y = mapTile.getY_coordinate();
            int draw = mapTile.getDrawable_int();

            ivCell[x][y].setImageDrawable(drawCell[draw]);
            Toast.makeText(getActivity(), "tile added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    //    post: sets beads displayed as actual value of beads
    private void UpdateBeadDisplay() {
        GlobalActivity globalActivity = (GlobalActivity)getActivity().getApplication();
        int beadi=globalActivity.getBeads();

        String beads = String.valueOf(beadi);
        beadDisplay.setText(beads);
    }

//    post: adding thing to database and stuff
    private void AddFirstTile() {

        List<MapTile> mapTileList = MainAppActivity.myAppDatabase.myDao().getMap();
        boolean isExist = false;
        for (MapTile mt : mapTileList) {
            if (mt.getX_coordinate() == 13 && mt.getY_coordinate() == 13) {
                isExist = true;
            }
        }

        MapTile mapTile = new MapTile();
        mapTile.setX_coordinate(13);
        mapTile.setY_coordinate(13);
        mapTile.setDrawable_int(1);

        if(isExist) {
            MainAppActivity.myAppDatabase.myDao().updateMapBlock(mapTile);
            Toast.makeText(getActivity(), "tile 1313 has been updated", Toast.LENGTH_SHORT).show();
        } else {
            MainAppActivity.myAppDatabase.myDao().addMapTile(mapTile);
            Toast.makeText(getActivity(), "tile 1313 has been added", Toast.LENGTH_SHORT).show();
        }
    }

//    post: opens up new fragment with map editing options of adding the next tile
    private void openEditFragment() {
        EditMapFragment nextFrag= new EditMapFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flEditMap, nextFrag,"findThisFragment")
//                .addToBackStack(null)
                .commit();

    }

//    matches resource to drawable number
//    todo put this permanently in a database, so it doesn't need to load each time
    private void loadDrawableResources() {
        drawCell[0] = null; // background
        drawCell[1] = context.getResources().getDrawable(R.drawable.grass_tile);
        drawCell[2] = context.getResources().getDrawable(R.color.blueGradStart);
    }

    private void initializeMap() {
//        create layout params to optimize
//        create a horizontal linear layout for a row which contains maxN image view
//        need to find outsize of cell first

        int sizeofCell = (int) ScreenWidth() / maxN;
        LinearLayout.LayoutParams lpRow = new LinearLayout.LayoutParams(sizeofCell*maxN, sizeofCell);
        LinearLayout.LayoutParams lpCell = new LinearLayout.LayoutParams(sizeofCell, sizeofCell);

//        create cells
        for(int i = 0; i < maxN; i++) {
            LinearLayout linRow = new LinearLayout(context);
//            make a row
            for (int j = 0; j < maxN; j++) {
//                make a cell
                ivCell[i][j] = new ImageView(context);
//               set bg as sky
                ivCell[i][j].setImageDrawable(drawCell[2]);
                linRow.addView(ivCell[i][j], lpCell);
            } // for
            linBoardGame.addView(linRow, lpRow);
        } // for
    }


    //    todo happens only once! prepopulates the whole database
    private void populateDatabase() {

        int x_value = 13;
        int y_value = 13;
        boolean turn_switch = true;
        int draw = 2;
        List<MapTile> mapTileList = MainAppActivity.myAppDatabase.myDao().getMap();

        boolean isExist = false;
        for (MapTile mt : mapTileList) {
            if (mt.getX_coordinate() == 13 && mt.getY_coordinate() == 13) {
                isExist = true;
            }
        }

        if (!isExist) {

            MapTile mapTile = new MapTile(); // dummy tile that will hold all changes

            for (int i = 1; i <= 25; i++) {
                if (turn_switch) {

//                this stuff makes the tiles twist and turn
                    for (int j = 1; j <= i; j++) {
                        x_value += 1;
                        addMapTile(mapTile, x_value, y_value, draw);

                        y_value -= 1;
                        addMapTile(mapTile, x_value, y_value, draw);
                    }
                    turn_switch = false;
                } else {
                    for (int j = 1; j <= i; j++) {
                        x_value -= 1;
                        addMapTile(mapTile, x_value, y_value, draw);

                        y_value += 1;
                        addMapTile(mapTile, x_value, y_value, draw);
                    }
                    turn_switch = false;
                }
            }
        }
    }

    private void addMapTile(MapTile mapTile, int x_value, int y_value, int draw) {
        mapTile.setX_coordinate(x_value);
        mapTile.setY_coordinate(y_value);
        mapTile.setDrawable_int(draw);
        MainAppActivity.myAppDatabase.myDao().addMapTile(mapTile);
    }


    //    returns device screen width
    private float ScreenWidth() {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}