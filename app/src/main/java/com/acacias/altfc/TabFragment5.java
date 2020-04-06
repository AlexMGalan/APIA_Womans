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

public class TabFragment5 extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players={
            "1-Keira Schwereb",
            "80-Olivia Chapman",
            "81-Jessica Lampasona",
            "82-Layla Hamden",
            "83-Ella Botwood",
            "84-Claudia Parinetto",
            "85-Alyssa Walsh",
            "86-Xanthe Coote",
            "87-Zoey Patterson",
            "88-Ava Boeckenhauer",
            "89-Mya Callil",
            "90-Luca Mackinnon",
            "91-Olivia Mazzotta",
            "92-Mia Lay",
            "93-Daniela Mandile",
            "94-Isabelle Antoniou" };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.keira_schwereb,R.drawable.olivia_chapman,R.drawable.jess_lamp,R.drawable.layla_hamdan,
            R.drawable.ella_botwood,R.drawable.claudia_parinetto, R.drawable.alyssa_walsh,R.drawable.xanthe_coote
            ,R.drawable.zoe_patterson,R.drawable.ava_boeckenhauer,R.drawable.mya_calil,R.drawable.luca_mackinnon
            ,R.drawable.olivia_mazzotta,R.drawable.mia_lay,R.drawable.daniela_mandile,R.drawable.isabelle_antoniou
    };

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_5, container, false);

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
