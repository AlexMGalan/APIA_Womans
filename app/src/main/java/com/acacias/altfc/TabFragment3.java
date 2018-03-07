package com.acacias.altfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TabFragment3 extends Fragment {

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

        View v = inflater.inflate(R.layout.tab_fragment_3, container, false);
        listView = (ListView) v.findViewById(R.id.recipe_list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Squadnames));

        String[]
                values1st = new String[] {
                "40-Claira Jovanovski",
                "42-Beth Sanderson",
                "41-Abbey Harrison",
                "54-Alyssa Sklias",
                "47-Tiarne Schuman",
                "48-Alannah Galan",
                "53-Christina Spathis",
                "55-Lara Mascaro",
                "49-Ally Beaufils",
                "44-Hazel Duwenbeck",
                "43-Alina Stojevski",
                "50-Maya Urquhart",
                "51-Marissa Papoulidis",
                "45-Moya Denford",
                "52-Natalie Bartolotto",
                "46-Mia Rea"};

        //1st Grade
        listView.setAdapter(null);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values1st);

        // Assign adapter to ListView
        listView.setAdapter(adapter0);

        return v;

    }
}
