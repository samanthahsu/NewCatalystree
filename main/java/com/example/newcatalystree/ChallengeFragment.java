package com.example.newcatalystree;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ChallengeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    //    create new instance of this fragment
    public static ChallengeFragment newInstance() {
        ChallengeFragment fragment = new ChallengeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ChallengeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_challenge, container, false);


//      the first beautiful pop up
        Button btTask1 = view.findViewById(R.id.btTask1);
        btTask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTask1Fractal();
            }
        });

/*
        Button btTask2 = view.findViewById(R.id.btTask2);
        btTask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTask2Fractal();
            }
        });
*/

        return view;
    }

    private void openTask1Fractal() {
//        todo PASS STRING PARAM TO TASK FRACTAL
//        TODO ALSO USE NEWINSTANCE INSTEAD OF THIS THING
//        place the string into

        ChallengeTaskFractal nextFrag= new ChallengeTaskFractal();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flTask, nextFrag,"findThisFragment")
//                .addToBackStack(null)
                .commit();
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
        void onFragmentInteraction(Uri uri);
    }
}
