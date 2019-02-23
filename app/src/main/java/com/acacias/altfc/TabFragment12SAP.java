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
            "20-Indie Smith",
            "47-Charlotte Douglas",
            "48-Kaya Mc Court",
            "49-Isabelle Zoghbi",
            "50-Georgia Bivona",
            "51-Anastasia Petratos",
            "52-Ruby Wiefler",
            "53-Arabella Conroy",
            "54-Sarah Mc Phail",
            "55-Claudia Lacalandra",
            "56-Lucie Atkin Bolton",
            "57-Alexia Karakaidos",
            "58-Maria Tsavalias",
            "59-Tori Hronopoulos"};


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.indie_s,R.drawable.noi,R.drawable.noi,R.drawable.noi,
            R.drawable.geor_b,R.drawable.noi, R.drawable.ruby_w,R.drawable.noi
            ,R.drawable.sarah_m,R.drawable.claudia_l,R.drawable.lucia_a,R.drawable.alexia_k
            ,R.drawable.maria_t,R.drawable.tori_h};

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
