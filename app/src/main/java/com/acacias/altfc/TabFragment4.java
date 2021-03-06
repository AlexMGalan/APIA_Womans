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

public class TabFragment4 extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players={
            "20-Eleni Martikas",
            "62-Lara Nero",
            "63-Ellen Wlodarczyk",
            "64-Adriana Tsatsimas",
            "65-Cameron Janssen",
            "66-Jenna Sklias",
            "67-India Eccles",
            "68-Olive O'Grady",
            "70-Charlotte Heath",
            "71-Caterina Mazzotta",
            "72-Alyssa Thomson",
            "73-Erin Diavatiotis",
            "74-Sophia Karatasos",
            "75-Chloe Golchini",
            "76-Sophie Ingham",
            "77-Stephanie Hansen"
    };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.eleni_martikas,R.drawable.lara_nero,R.drawable.ellen_wlodarczk,R.drawable.andriana_tsatsimas,
            R.drawable.cameron_janssen,R.drawable.jenna_sklias, R.drawable.india_eccels,R.drawable.olive_o
            ,R.drawable.charlotte_heath,R.drawable.caterina_mazzotta,R.drawable.alyssa_thomson,R.drawable.erin_diavatiotis
            ,R.drawable.sophia_karatasos,R.drawable.chloe_golchini,R.drawable.sophie_ingham,R.drawable.stephanie_hansen
    };

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_4, container, false);

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
