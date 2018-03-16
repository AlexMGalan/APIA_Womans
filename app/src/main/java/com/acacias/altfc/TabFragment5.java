package com.acacias.altfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TabFragment5 extends Fragment {

    ListView listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_5, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        String[]
                values1st = new String[] {
                "20-Thea Draganova",
                "94-Natalia Giannakos",
                "93-Ella Griffin",
                "92-Gabby Mc Ainish",
                "91-Amy Redden",
                "90-Ruby De Gouw",
                "89-Jenna Sklias",
                "88-Eva Ragg",
                "87-India Eccles",
                "86-Anneka Wood",
                "85-Kristabelle	Oo",
                "84-Jessika Talbot",
                "83-Emma Chiew",
                "82-Jale Kandemir",
                "81-Mia Bitar",
                "80-Evie Gallagher"};

        //1st Grade
        listView.setAdapter(null);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

        // Assign adapter to ListView
        listView.setAdapter(adapter0);

        return v;

    }
}
