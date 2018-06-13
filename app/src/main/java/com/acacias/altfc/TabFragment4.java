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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_4, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        String[]
                values1st = new String[] {
                "60-Giordana Cicchini",
                "62-Amy Tran",
                "63-Natalie Marchese",
                "64-Talisa Grey",
                "65-Aleisha Camporeale",
                "66-Vanessa Vlach",
                "67-Lilly Dummett",
                "68-Nikky Murray",
                "70-Sophia Issa",
                "71-Ashleigh Warr",
                "72-Sorcha Ryall",
                "73-Caitlin Webster",
                "74-Therese Bechara",
                "75-Lone Bromley",
                "76-Vivienne Dehn",
                "77-Alix Morrant"};

        //1st Grade
        listView.setAdapter(null);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

        // Assign adapter to ListView
        listView.setAdapter(adapter0);

        return v;

    }
}
