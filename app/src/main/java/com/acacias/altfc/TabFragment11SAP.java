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

public class TabFragment11SAP extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players11={
            "1-GK TBA",
            "67-Allegra Marando",
            "68-Giulia Pappas",
            "70-Gabby Boutros",
            "71-Maja Heald",
            "72-Ava Morris",
            "73-Maleeka Chalak",
            "74-Jade Labalan",
            "75-Elenor Lenton",
            "76-Charlotte Mintzas",
            "77-Miki Cooper",
            "78-Ines Medley",
            "79-Ava Boutros",
            "80-Stella Trieste"    };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi,
            R.drawable.noi,R.drawable.noi, R.drawable.noi,R.drawable.noi
            ,R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi, R.drawable.noi,  R.drawable.noi};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_sap11, container, false);

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players11.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players11[i]);
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
