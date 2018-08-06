package com.acacias.altfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import static com.acacias.altfc.MainActivity.myNews;


public class ListItemActivity2 extends Fragment {


    public ListItemActivity2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.list_item_activity_2, container, false);

        //Get the Round Nbr
        final Integer value = getArguments().getInt("NewsItem");


        getActivity().setTitle("News");

        Toolbar mToolbar = (Toolbar) v.findViewById(R.id.toolbar);
        mToolbar.setTitle("Back");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewsFragment fragment2 = new NewsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainLayout, fragment2);
                fragmentTransaction.commit();
            }
        });

        //Set up Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child(String.valueOf("News"));

        final String NewsNbr = String.valueOf(value+1);

        // For Listener, get data direct from snapshot
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Match Report
                TextView tvNews = (TextView) v.findViewById(R.id.txtNews);

                myNews = dataSnapshot.child(NewsNbr).getValue(String.class).replace("_n", "\n");
                tvNews.setText(myNews);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;

    }}
