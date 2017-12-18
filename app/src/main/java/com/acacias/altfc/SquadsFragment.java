package com.acacias.altfc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SquadsFragment extends Fragment {

    ListView listView ;


    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;
    public SquadsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //   return inflater.inflate(R.layout.fragment_squads, container, false);

        View v = inflater.inflate(R.layout.fragment_squads, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        Spinner mySpinner = (Spinner) v.findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setSelection(0);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String[]
                        values17 = new String[] {
                        "Coach: Robbie Maiorana",
                        "Manager: Lisa Wollaston",
                        "74 A. Beaufils",
                        "49 T. Bosilkovski",
                        "41 M. Denford",
                        "51 H. Duwenbeck",
                        "45 C. Eaton",
                        "76 A. Galan",
                        "44 A. Griffin",
                        "48 A. Harrison",
                        "75 J. Kappas,",
                        "30 S. Marsh",
                        "46 L. Masterton-Smith",
                        "53 A. Mcdonald",
                        "42 B. Sanderson",
                        "43 T. Schuman",
                        "50 A. Stojcevski",
                        "54 M. Urquhart"};

                String[]
                        values15 = new String[] {
                        "Coach: Ernesto Bivona",
                        "Manager: Sharon Fletcher",
                        "60 S. Bamonte",
                        "71 N. Bartolotto",
                        "74 A. Beaufils",
                        "52 E. Burgess",
                        "64 L. Dummett",
                        "63 A. Fletcher",
                        "65 T. Gray",
                        "61 S. Issa",
                        "75 J. Kappas",
                        "72 A. Limnios",
                        "66 N. Marchese",
                        "67 N. Murray",
                        "68 B. Phillips",
                        "73 G. Qassis",
                        "62 M. Rea",
                        "70 V. Vlach"};

                String[]
                        values1st = new String[] {
                        "Coach: Matteo Maiorana",
                        "Mangager: Robbie Maiorana",
                        "16 J. Bennett",
                        "8 C. Canini",
                        "22 N. Carmichael",
                        "5 O. Cicco",
                        "7 E. Clout",
                        "9 C. Ferreyra",
                        "2 S. Glanville-Fyfe",
                        "1 C. Halpin1",
                        "2 M. Latham1",
                        "5 K. Manias",
                        "20 G. Raymond",
                        "R. Scarlato",
                        "4 S. Scarlato",
                        "13 M. Sim-Sing",
                        "38 S. Urquhart",
                        "14 R. Watts"};

                switch (position) {
                    case 0:
                        //1st Grade
                        listView.setAdapter(null);
                        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                                android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

                        // Assign adapter to ListView
                        listView.setAdapter(adapter0);
                        break;
                    case 1:
                        //Reserves
                        listView.setAdapter(null);
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
                                android.R.layout.simple_list_item_1, android.R.id.text1, values17);

                        // Assign adapter to ListView
                        listView.setAdapter(adapter1);
                        break;

                    case 2:
                        //Under 17
                        listView.setAdapter(null);
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
                                android.R.layout.simple_list_item_1, android.R.id.text1, values17);

                        // Assign adapter to ListView
                        listView.setAdapter(adapter2);
                        break;
                case 3:
                        //Under 15
                        listView.setAdapter(null);
                        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),
                                android.R.layout.simple_list_item_1, android.R.id.text1, values15);

                        // Assign adapter to ListView
                        listView.setAdapter(adapter3);
                        break;
            }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        getActivity().setTitle("APIA Squads");





        // ListView Item Click Listener
     //   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

          //  @Override
           // public void onItemClick(AdapterView<?> parent, View view,
           //                         int position, long id) {

                // ListView Clicked item index
            //    int itemPosition     = position;

                // ListView Clicked item value
              //  String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
              //  Toast.makeText(getActivity(),
              //          "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
              //          .show();

           // }

       // });

        return v;



    }



}
