package com.acacias.altfc;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextGameFragment extends Fragment {



    public NextGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_history, container, false);

        View v = inflater.inflate(R.layout.fragment_next_game, container, false);

        getActivity().setTitle("Next Game");



        //Set up database
       DatabaseHandler db = new DatabaseHandler(getActivity());

        // Inserting Contacts
        db.addPlayer(new Player(1,76,"Alannah", "Galan"));
        db.addMatch(new Match("11/03/2018","Southern Branch","APIA", "SOUTH NOWRA FOOTBALL COMPLEX", "3:00PM", "3:00PM", "3:00PM","3:00PM","3:00PM" ));


        // Reading all contacts
        //Log.d("Reading: ", "Reading all contacts..");
        List<Match> Matches = db.getAllMatches();

     //   for (Match cn : Matches) {
       //       Toast.makeText(getActivity(), "Next Match: " + cn.getDate() + ": " + cn.getHomeTeam() + " vs " + cn.getVisitTeam(),
       //               Toast.LENGTH_LONG).show();
      //  }

        TextView TVDate = (TextView)v.findViewById(R.id.textViewDate);
        TVDate.setText("My Awesome Text");




        return v;
    }


}
