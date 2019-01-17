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

public class TabFragment1 extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players={
            "1-Courtney Halpin",
            "2-Jen Bennett",
            "3-Jenny Bisset",
            "4-Lara Bosnich",
            "5-Olivia Cicco",
            "6-Lucy Gilfedder",
            "7-Carla Canini",
            "8-Cass Chidgey",
            "9-Logan Garard",
            "10-Filiz Urkanci",
            "11-Ash Palombi",
            "12-Maddie Latham",
            "13-Sarah Urquhart",
            "14-Becky Watts",
            "15-Nicole Carmichael",
            "17-Kerrie Ryan",
            "18-Jessica Fallah",
            "24-Georgia Bridges",
            "40-Stephanie Grimbilos" };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.halp,R.drawable.ben,R.drawable.noi,R.drawable.noi,
            R.drawable.cic,R.drawable.gil, R.drawable.can,R.drawable.noi
            ,R.drawable.noi,R.drawable.urk,R.drawable.palo,R.drawable.lath
            ,R.drawable.urq,R.drawable.noi,R.drawable.car,R.drawable.noi
            ,R.drawable.noi,R.drawable.noi,R.drawable.noi};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
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
