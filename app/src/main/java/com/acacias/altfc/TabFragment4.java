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
            "20-Bianca Musumeci",
            "64-Paulina Katsionis",
            "65-Jessica Talbot",
            "66-Kaitlyn Halkidis",
            "67-Natalie Moujalli",
            "68-Alyssa Broughton",
            "70-Sienna Broughton",
            "71-Caitlin Stringer",
            "72-Aleisha Camporeale",
            "73-Isabella Obuzome",
            "74-Emma Chiew",
            "75-Nat Giannakos",
            "76-Jenna Sklias",
            "77-Amy Redden",
            "78-Gabby Mc Ainsh",
            "79-Anneka Wood"};


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi,
            R.drawable.noi,R.drawable.noi, R.drawable.noi,R.drawable.noi
            ,R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi
            ,R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi
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
