package com.example.newcatalystree;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressLint("NewApi")

public class MapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    //    declare int for board site
    final static int maxN = 25;
    Context context;
    //    declare for imageView (Cells) array
    ImageView[][] ivCell = new ImageView[maxN][maxN];
    Drawable[] drawCell = new Drawable[4]; // 0 is empty, 1 is player, 2 is bot, 3 is bg
    private LinearLayout linBoardGame;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        linBoardGame = view.findViewById(R.id.linBoardGame);

        context = getContext();
        loadResources();
        makeMap();
        updateMap();

        Button btEdit = view.findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_edit_fragment();
            }
        });

        return view;
    }

    private void updateMap() {
        ivCell[13][13].setImageDrawable(drawCell[1]); // todo doesnt seem to be able to change the tile...
//        linBoardGame
    }

    private void open_edit_fragment() {
//        prevent map from zooming
//        todo: open map overlay which is new fragment unclickable, but makes the actual map clickable
//        if actual map tile clicked, it becomes a ground map

    }

    private void loadResources() {
        drawCell[0] = null; // background
        drawCell[3] = context.getResources().getDrawable(R.drawable.cell_bg); // cat icon appa
        drawCell[1] = context.getResources().getDrawable(R.drawable.sample_tile);
        drawCell[2] = context.getResources().getDrawable(R.drawable.sample_tile_1);
//        copy 2 image for 2 drawable player and bot
//        edit it
    }

    private void makeMap() {
//        create layout params to optimize
//        create a horizontal linear layout for a row which contains maxN image view
//        need to find outsize of cell first

        int sizeofCell = Math.round(50); // resizes cell according to screen size todo change to pixel?
        LinearLayout.LayoutParams lpRow = new LinearLayout.LayoutParams(sizeofCell*maxN, sizeofCell);
        LinearLayout.LayoutParams lpCell = new LinearLayout.LayoutParams(sizeofCell, sizeofCell);

//        create cells
        for(int i = 0; i < maxN; i++) {
            LinearLayout linRow = new LinearLayout(context);
//            make a row
            for (int j = 0; j < maxN; j++) {
//                make a cell
                ivCell[i][j] = new ImageView(context);
//                need to get background default for cell
//                cell has 3 status, empty(default, player, bot
                ivCell[i][j].setImageDrawable(drawCell[2]);
                linRow.addView(ivCell[i][j], lpCell);
            } // for
            linBoardGame.addView(linRow, lpRow);
        } // for
//        ImageView ivX;
//        RelativeLayout rlMapElements = new RelativeLayout();
//        rlMapElements.inflate(ivX);
//
//        onclick of editing button
//        put add button to the top, right, bottom, left, of ivX
//        check if the block is at the extremities of the earth todo: howwwww????
//        put add buttons to all the areas at the extremeties not yet occupied by a block

//        if add button onclick listener, it adds a block at that spot


//        Resources from the R.xx.xx portion of your app, are given an Integer constant as an identifier.
// If you wanted to then make an array of R.drawable.image you could just make it an int[]
//        eg: int[]   mArray = new int[10];
        //    mArray[0] = R.drawable.image1;
        //    mArray[1] = R.drawable.image2;
    }

    private float ScreenWidth() {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}