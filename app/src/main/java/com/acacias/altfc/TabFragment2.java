package com.acacias.altfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TabFragment2 extends Fragment {

    ListView listView ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        String[]
                values1st = new String[] {
                "16-Emma Mason",
                "24-Hannah Macri",
                "25-Kim Cozens",
                "26-Victoria Kakoliris",
                "27-Nicola Simmons",
                "28-Maddie Gray",
                "29-Emily Smith",
                "31-Bojana Poletanovic",
                "32-Dione King",
                "33-Claire Kartambis",
                "34-Elizabeth De Nobrega",
                "35-Alara Inal",
                "36-Amelia Griffin",
                "37-Carley Dimitropolous" };

        //1st Grade
        listView.setAdapter(null);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

        // Assign adapter to ListView
        listView.setAdapter(adapter0);

        return v;

    }
}
