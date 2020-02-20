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

public class TabFragment13SAP extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players13={
            "1-Indie Smith",
            "27-Charlotte Douglas",
            "28-Alana Lekov",
            "29-Billy Rose Talai",
            "30-Saskia Emery",
            "31-Stella Valenti",
            "32-Mia Golchini",
            "33-Kaya Mc Court",
            "34-Isabelle Zoghbi",
            "35-Georgia Bivona",
            "36-Eve Court",
            "37-Ruby Wiefler",
            "38-Claudia Lacalandra",
            "39-Alexia Karakaidos",
            "40-Tori Hronopoulos"
    };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.indie_smith,R.drawable.charlotte_douglas,R.drawable.elana_lekov,R.drawable.billy_rose,
            R.drawable.saskia_emery,R.drawable.stella_valenti, R.drawable.mia_golchini,R.drawable.kaya_mccourt
            ,R.drawable.isabelle_zoghbi,R.drawable.georgia_bivona,R.drawable.eve_court,R.drawable.ruby_wiefler
            ,R.drawable.claudia_lacalandra,R.drawable.alexia_karakaidos,R.drawable.tori_hronopolous};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_sap13, container, false);

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players13.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players13[i]);
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
