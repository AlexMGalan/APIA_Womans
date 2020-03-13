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

public class TabFragment2 extends ListFragment {

    ListView listView ;
    private String[] drawerListViewItems;
    private ListView drawerListView;

    String[] players={
            "20-Amy Dahdah",
            "21-Ella Mastrantonio",
            "22-Hannah Macri",
            "23-Marissa Papoulidis",
            "24-Genevieve Tucker",
            "25-Lauren Pruscino",
            "26-Alexandra Timms",
            "27-Ailish McDonagh",
            "28-Abbey Harrison",
            "29-Beth McGhee",
            "30-Sophie Magus",
            "31-Alyssa Janssen",
            "32-Lillian Dummett",
            "33-Alina Stojevski",
            "34-Alannah Galan",
            "35-Tara Pender",
            "36-Georgia Yeoman-Dale",
            "39-Georgia Bridges",
            "40-Stephanie Grimbilos" };


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images={R.drawable.amy_dahdah, R.drawable.ella_matrantonio, R.drawable.hannah_macri,R.drawable.marissa_papoulidis,R.drawable.genevieve_tucker,R.drawable.lauren_pruscino,
            R.drawable.alex_tims,R.drawable.ailish_mcdonagh, R.drawable.abby_harrison,R.drawable.bethany_mcghee
            ,R.drawable.sophie_magus,R.drawable.alyssa_janssen,R.drawable.lilly_dummett,R.drawable.alina_stojcevski
            ,R.drawable.alannah_galan,R.drawable.tara_pender,R.drawable.georgia_yeoman_dale, R.drawable.georgia_bridges, R.drawable.stephanie_grimbilos
            };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] sponsors={R.drawable.enviro,R.drawable.strategic_pest,R.drawable.decc,R.drawable.williams,
            R.drawable.audi,R.drawable.urban, R.drawable.blank,R.drawable.dulwich
            ,R.drawable.annandale,R.drawable.camperdown,R.drawable.williams,R.drawable.artgame
            ,R.drawable.di_lorenzo,R.drawable.nova,R.drawable.acaciasw_small,R.drawable.bac
            ,R.drawable.apac,R.drawable.fruit, R.drawable.smart};


    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));
            map.put("Sponsor", Integer.toString(sponsors[i]));

            data.add(map);
        }

        //KEYS IN MAP
        String[] from={"Player","Image", "Sponsor"};

        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView1 ,R.id.imageSpon};

        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model_sen, from, to);
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
