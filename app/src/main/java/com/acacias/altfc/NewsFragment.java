package com.acacias.altfc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class NewsFragment extends Fragment {

    private ListView mListView;

public NewsFragment() {
        // Required empty public constructor
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_news, container, false);

        getActivity().setTitle("News");


        // Find the ListView
        mListView = (ListView) v.findViewById(R.id.listViewNews);

        /*
         * Create a DatabaseReference to the data; works with standard DatabaseReference methods
         * like limitToLast() and etc.
         */
        DatabaseReference newsReference = FirebaseDatabase.getInstance().getReference()
                .child("News");

        // Now set the adapter with a given layout
    //    mListView.setAdapter(new FirebaseListAdapter<News>(getActivity(), News.class,
      //          android.R.layout.simple_list_item_1, newsReference) {

            // Populate view as needed
       //     @Override
       //     protected void populateView(View view, News news, int position) {
        //        ((TextView) view.findViewById(android.R.id.text1)).setText(news.getNews());
       //     }
      //  });


            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                ListItemActivity2 fragment2 = new ListItemActivity2();
                FragmentManager fragmentManager = getFragmentManager();
                Bundle args = new Bundle();
                args.putInt("NewsItem", position);
                fragment2.setArguments(args);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainLayout, fragment2);
                fragmentTransaction.commit();
            }
        });

        return v;

    }

}
