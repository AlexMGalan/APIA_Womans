package com.acacias.altfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class TabFragment12SAP extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players12={
            "1-Charlotte So",
            "50-Charlotte Butler",
            "51-Matisse Emery",
            "52-Tayla Hand",
            "53-Samantha Pak",
            "54-Isabel Fitzpatrick",
            "55-Cecilia Cicco",
            "56-Alexia Mavraidis",
            "57-Bianka Pavela",
            "58-Eliana Tzouganatos",
            "59-Allegra Butera",
            "60-Lexi Modena" };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.charlotte_so,R.drawable.charlotte_butler,
            R.drawable.matisse_emery,R.drawable.tayla_hand, R.drawable.samantha_pak,R.drawable.isabelle_fitzpatrick
            ,R.drawable.cecilia_cicco,R.drawable.alexia_mavraidis,R.drawable.bianka_pavela,R.drawable.eliana_tzouganatos
            ,R.drawable.allegra_butera ,R.drawable.lexi_modena};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_sap12, container, false);

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players12.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players12[i]);
            map.put("Image", Integer.toString(images[i]));

            data.add(map);
        }

        //KEYS IN MAP
        String[] from={"Player","Image"};

        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView1};

        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub

                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

            }
        });


    }

}
