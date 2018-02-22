package com.acacias.altfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TabFragment4 extends Fragment {

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

        View v = inflater.inflate(R.layout.tab_fragment_4, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        String[]
                values1st = new String[] {
                "Coach: Claudio",
                "Mangager: Luciano Marchese",
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

        //1st Grade
        listView.setAdapter(null);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

        // Assign adapter to ListView
        listView.setAdapter(adapter0);

        return v;

    }
}