package com.acacias.altfc;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NextGameFragment extends Fragment {

    int  IPOS;
    String sReport;
    int  IFirstLoad;
    View v;
    static boolean called=false;
    int sRound;

    public NextGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_next_game, container, false);
        getActivity().setTitle("Next Game");

        IFirstLoad=1;
        IPOS=0;
        sReport="";

        // Call Google Maps Activity
        TextView tvmap= (TextView)v.findViewById(R.id.textViewMAP);
        tvmap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("Round", IPOS);
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

        //Set up Spinner for Rounds and Dates
        Spinner mySpinner = (Spinner) v.findViewById(R.id.spRound);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rounds));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        //Listener for Rounds Spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                sRound= position;


                LoadScreen(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });


        return v;}

    //Main Load Screen
    void LoadScreen(int Pos) {

        if (IFirstLoad == 1) {
            IPOS = 22;
        } else {
            IPOS = Pos + 1;
        }


        if (!called)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            called = true;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String currentDate = sdf.format(new Date());

        sRound=sRound+1;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef  = database.getReference().child( Integer.toString(sRound));

        // DatabaseReference myRef = database.getReference();

// For Listener, get data direct from snapshot
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Date
                TextView tvDate= (TextView) v.findViewById(R.id.textviewDate);
                tvDate.setText(dataSnapshot.child("Date").getValue(String.class));


                //Ground
                TextView tvGround= (TextView) v.findViewById(R.id.textViewGround);
                tvGround.setText(dataSnapshot.child("Ground").getValue(String.class));

                //Address
                TextView tvAddress= (TextView) v.findViewById(R.id.textviewAddress);
                tvAddress.setText(dataSnapshot.child("Address").getValue(String.class));


                if (tvGround.getText().equals("Lambert Park")) {

                    ImageView IVLogohome = (ImageView) v.findViewById(R.id.imageViewHOME);
                      IVLogohome.setImageResource(R.mipmap.apia_logo);

                       ImageView IVVisit = (ImageView) v.findViewById(R.id.imageViewVISIT);
                       Context context = IVLogohome.getContext();
                       int idl = context.getResources().getIdentifier(dataSnapshot.child("Logo").getValue(String.class), "mipmap", context.getPackageName());
                       IVVisit.setImageResource(idl);


                    TextView tvHome = (TextView) v.findViewById(R.id.textViewHome);
                    tvHome.setText("APIA Leichhardt");

                    TextView tvVisit = (TextView) v.findViewById(R.id.textViewVisit);
                    tvVisit.setText(dataSnapshot.child("Opponent").getValue(String.class));

                } else {

                     ImageView IVLogohome = (ImageView) v.findViewById(R.id.imageViewHOME);
                     Context context = IVLogohome.getContext();
                     int idl = context.getResources().getIdentifier(dataSnapshot.child("Logo").getValue(String.class), "mipmap", context.getPackageName());
                     IVLogohome.setImageResource(idl);

                     ImageView IVVisit = (ImageView) v.findViewById(R.id.imageViewVISIT);
                     IVVisit.setImageResource(R.mipmap.apia_logo);

                    TextView tvHome = (TextView) v.findViewById(R.id.textViewHome);
                    tvHome.setText(dataSnapshot.child("Opponent").getValue(String.class));

                    TextView tvVisit = (TextView) v.findViewById(R.id.textViewVisit);
                    tvVisit.setText("APIA Leichhardt");
                }

                //FirstGrade
                   TextView tv1HomeScore = (TextView) v.findViewById(R.id.textView1HomeScore);
                   tv1HomeScore.setText(dataSnapshot.child("1GradeHome").getValue(String.class));

                   TextView tv1VisitScore = (TextView) v.findViewById(R.id.textView1VisitScore);
                  tv1VisitScore.setText(dataSnapshot.child("1GradeVisit").getValue(String.class));

                //Res
                 TextView tv2HomeScore = (TextView) v.findViewById(R.id.textView2HomeScore);
                 tv2HomeScore.setText(dataSnapshot.child("2GradeHome").getValue(String.class));

                 TextView tv2VisitScore = (TextView) v.findViewById(R.id.textView2VisitScore);
                 tv2VisitScore.setText(dataSnapshot.child("2GradeVisit").getValue(String.class));

                //17
                 TextView tv3HomeScore = (TextView) v.findViewById(R.id.textView3HomeScore);
                  tv3HomeScore.setText(dataSnapshot.child("3GradeHome").getValue(String.class));

                  TextView tv3VisitScore = (TextView) v.findViewById(R.id.textView3VisitScore);
                  tv3VisitScore.setText(dataSnapshot.child("3GradeVisit").getValue(String.class));

                //15
                  TextView tv4HomeScore = (TextView) v.findViewById(R.id.textView4HomeScore);
                  tv4HomeScore.setText(dataSnapshot.child("4GradeHome").getValue(String.class));

                  TextView tv4VisitScore = (TextView) v.findViewById(R.id.textView4VisitScore);
                   tv4VisitScore.setText(dataSnapshot.child("4GradeVisit").getValue(String.class));

                //14
                  TextView tv5HomeScore = (TextView) v.findViewById(R.id.textView5HomeScore);
                  tv5HomeScore.setText(dataSnapshot.child("5GradeHome").getValue(String.class));

                  TextView tv5VisitScore = (TextView) v.findViewById(R.id.textView5VisitScore);
                  tv5VisitScore.setText(dataSnapshot.child("5GradeVisit").getValue(String.class));

            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });


        IFirstLoad = 0;
}


}

