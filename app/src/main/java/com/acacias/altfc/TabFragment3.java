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
            "40-Claira Jovanovski",
            "42-Beth Sanderson",
            "41-Abbey Harrison",
            "54-Alyssa Sklias",
            "47-Tiarne Schuman",
            "48-Alannah Galan",
            "53-Christina Spathis",
            "55-Lara Mascaro",
            "49-Ally Beaufils",
            "44-Hazel Duwenbeck",
            "43-Alina Stojevski",
            "50-Maya Urquhart",
            "51-Marissa Papoulidis",
            "45-Moya Denford",
            "52-Natalie Bartolotto",
            "46-Mia Rea"};


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
