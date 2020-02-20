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

public class TabFragment3 extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players={
            "41-Therese Bechara",
            "42-Sophia Konstandinidis",
            "43-Caitlin Stringer",
            "44-Tarsha Wayne",
            "45-Sienna Excell",
            "46-Georgia Tropea",
            "47-Lucia White",
            "48-Chloe Harman",
            "49-Mia Domine",
            "50-Emiljia Vidakovic",
            "51-Samantha Cefai",
            "52-Annaliese Batshon",
            "53-Caitlin Webster",
            "54-Alyssa Schwereb",
            "55-Dani Rutstein",
            "56-Natalie Marchese"
    };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.therese_bechara,R.drawable.sophia_konstandinidis,R.drawable.caitlin_stringer,R.drawable.tarsha_wayne,
            R.drawable.sienna_excell,R.drawable.georgia_tropea, R.drawable.lucia_white,R.drawable.chloe_harman
            ,R.drawable.mia_domine,R.drawable.emilija_vidakovic,R.drawable.samantha_cefai,R.drawable.annaliese_batshon
            ,R.drawable.caitlin_webster,R.drawable.alyssa_schwereb,R.drawable.danielle_rutstein,R.drawable.natalie_marchese
    };

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_3, container, false);

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
