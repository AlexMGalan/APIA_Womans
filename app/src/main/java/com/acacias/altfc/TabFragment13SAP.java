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
            "1-Romy McCorquodale",
            "26-Sienna Hughes",
            "27-Grace Dunn",
            "28-Claudia Parinetto",
            "29-Maria Roumeliotis",
            "30-Lucia Bounavoglia",
            "31-Danielle Mandile",
            "32-Isabelle Antoniou",
            "33-Mya Calil",
            "34-Olivia Mazzotta",
            "35-Ava Boeckenhauer",
            "36-Maddox Fitzgibbon",
            "37-Olivia Chapman",
            "38-Alyssa Walsh",
            "39-Ella Botwood" };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi,
            R.drawable.noi,R.drawable.noi, R.drawable.noi,R.drawable.noi
            ,R.drawable.noi,R.drawable.noi,R.drawable.noi,R.drawable.noi
            ,R.drawable.noi,R.drawable.noi,R.drawable.noi};

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
