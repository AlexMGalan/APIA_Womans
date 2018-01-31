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
        // Log.d("Insert: ", "Inserting ..");
         db.addPlayer(new Player(1,7,"Carla", "Canini"));
       //   db.addContact(new Player("Srinivas", "9199999999"));
       //   db.addContact(new Player("Tommy", "9522222222"));
       //   db.addContact(new Player("Karthik", "9533333333"));

        // Reading all contacts
        //Log.d("Reading: ", "Reading all contacts..");
        List<Player> players = db.getAllPlayers();

        for (Player cn : players) {
              Toast.makeText(getActivity(), "Name: " + cn.getNumber() + "- " + cn.get_firstname() + " " + cn.get_lastname(),
                      Toast.LENGTH_LONG).show();

            //   String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " +
            //          cn.getPhoneNumber();
            // Writing Contacts to log
            //  Log.d("Name: ", log);
        }



        return v;
    }


}
