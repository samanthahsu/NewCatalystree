package com.example.newcatalystree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * 6/14/2018
 */
public class EditMapFragment extends Fragment {

    private Button addMapTile;
    static int addTileCost = 30;


    public EditMapFragment() {
        // Required empty public constructor
    }

    public static EditMapFragment newInstance() {
        EditMapFragment fragment = new EditMapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_map, container, false);

        addMapTile = view.findViewById(R.id.bt_add_maptile);
        addMapTile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                todo adds new map tile in database and updates map
                GlobalActivity globalActivity = (GlobalActivity)getActivity().getApplication();
                int beadi = globalActivity.getBeads();

//                subtract value
                if (beadi >= addTileCost) {
                    globalActivity.setBeads(beadi - 30);

                    addNewMaptile();
                }


            }
        });
        return view;
    }

    private void addNewMaptile() {

    }

}
