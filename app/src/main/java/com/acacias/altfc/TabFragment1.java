package com.acacias.altfc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TabFragment1 extends Fragment {

    ListView listView ;


    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
   // int clickCounter=0;
  //  public SquadsFragment() {
        // Required empty public constructor
   // }


    @Override
   // public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
   //     return inflater.inflate(R.layout.tab_fragment_1, container, false);

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        String[]
                values1st = new String[] {
                "1-Courtney Halpin",
                "3-Olivia Hardaker",
                "4-Samantha Scarlato",
                "5-Olivia Cicco",
                "6-Lucy Gilfedder",
                "8-Carla Canini",
                "9-Christy Ferreyra",
                "10-Filiz Urkanci",
                "11-Ashleigh Palombi",
                "12-Maddie Latham",
                "13-Beatrice Sim Sing",
                "14-Rebecca Watts",
                "15-Kylie Manias",
                "16-Jennifer Bennett",
                "17-Sarah Urquhart",
                "18-Jessica Martinez",
                "19-Karen Saavedra",
                "20-Stephanie Marsh",
                "21-Nicole Carmichael",
                "99-Gill Raymond" };

                //1st Grade
                listView.setAdapter(null);
                ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

                // Assign adapter to ListView
                listView.setAdapter(adapter0);
               // getActivity().setTitle("Squads");

        return v;

    }

    }
