package com.acacias.altfc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CoachesFragment extends Fragment {


    public CoachesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false);

        View v = inflater.inflate(R.layout.fragment_coaches, container, false);

        getActivity().setTitle("Coaches");


        return v;
    }

}
