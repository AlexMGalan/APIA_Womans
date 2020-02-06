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
            "2-Julia De Angelis",
            "3-Jen Bisset",
            "4-Elizabeth Ralston",
            "5-Alex Huynh",
            "6-Rhianna Pollicina",
            "7-Carla Abou-Haidar",
            "8-Deborah De La Harpe",
            "9-Logan Garard",
            "10-Ashleigh Palombi",
            "11-Princess Ibini",
            "12-Lara Bosnich",
            "13-Sarah Urquhart",
            "14-Rebecca Watts",
            "15-Nicole Carmichael",
            "16-Jen Bennett",
            "17-Natasha Aitken",
            "18-Jessica Fallah",
            "19-Sofia Merkoureaus",
            };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.courtney_halpin,R.drawable.julia_deangelis,R.drawable.jennifer_bisset,R.drawable.elizabeth_ralston,
            R.drawable.alex_huynh,R.drawable.rhianna_pollicina, R.drawable.carla,R.drawable.deborah_anne_delaharpe
            ,R.drawable.logan_garard,R.drawable.ashleigh_palombi,R.drawable.princess_ibini_isei,R.drawable.lara_bosnich
            ,R.drawable.sarah_urquhart,R.drawable.rebecca_watts,R.drawable.nicole_carmichael,R.drawable.jennifer_bennett
            ,R.drawable.natasha_aitken,R.drawable.jessica_fallah, R.drawable.sofia_merkoureas};

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
