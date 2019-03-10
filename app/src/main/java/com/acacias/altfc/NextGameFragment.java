package com.acacias.altfc;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    int  IFirstLoad;
    View v;
    static boolean called=false;
    int iRound;
    String sLat;
    String sLong;
    String sGround;

    public NextGameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_next_game, container, false);
        getActivity().setTitle("Next Game");

       // IFirstLoad=1;
        IPOS=0;

        //Set up Spinner for Rounds and Dates
        Spinner mySpinner = (Spinner) v.findViewById(R.id.spRound);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rounds));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        //Get current date
       String date1 = sdf.format(Calendar.getInstance().getTime());
//
        //Set up round dates
        String Round1 = "2019-03-10";
        String Round2 = "2019-03-17";
        String Round3 = "2019-03-24";
        String Round4 = "2019-03-31";
        String Round5 = "2019-04-07";
        String Round6 = "2019-04-14";
        String Round7 = "2019-04-22";
        String Round8 = "2019-04-28";
        String Round9 = "2019-05-05";
        String Round10 = "2019-05-12";
        String Round11 = "2019-05-19";
        String Round12 = "2019-05-26";
        String Round13 = "2019-06-02";
        String Round14 = "2019-06-09";
        String Round15 = "2019-06-16";
        String Round16 = "2019-06-23";
        String Round17 = "2019-06-30";
        String Round18= "2019-07-07";
        String Round19 = "2019-07-14";
        String Round20 = "2019-07-21";
        String Round21 = "2019-07-28";
        String Round22= "2019-08-04";

       iRound=1;

       //Get Next Round
        if(Round1.compareTo(date1) < 0) {iRound=2;};
        if (Round2.compareTo(date1) < 0) {iRound = 3; };
        if (Round3.compareTo(date1) < 0) {iRound = 4; };
        if (Round4.compareTo(date1) < 0) {iRound = 5; };
        if (Round5.compareTo(date1) < 0) {iRound = 6; };
        if (Round6.compareTo(date1) < 0) {iRound = 7; };
        if (Round7.compareTo(date1) < 0) {iRound = 8; };
        if (Round8.compareTo(date1) < 0) {iRound = 9; };
        if (Round9.compareTo(date1) < 0) {iRound = 10; };
        if (Round10.compareTo(date1) < 0) {iRound = 11; };
        if (Round11.compareTo(date1) < 0) {iRound = 12; };
        if (Round12.compareTo(date1) < 0) {iRound = 13; };
        if (Round13.compareTo(date1) < 0) {iRound = 14; };
        if (Round14.compareTo(date1) < 0) {iRound = 15; };
        if (Round15.compareTo(date1) < 0) {iRound = 16; };
        if (Round16.compareTo(date1) < 0) {iRound = 17; };
        if (Round17.compareTo(date1) < 0) {iRound = 18; };
        if (Round18.compareTo(date1) < 0) {iRound = 19; };
        if (Round19.compareTo(date1) < 0) {iRound = 20; };
        if (Round20.compareTo(date1) < 0) {iRound = 21; };
        if (Round21.compareTo(date1) < 0) {iRound = 22; };
        if (Round22.compareTo(date1) < 0) {iRound = 23; };

       if (iRound>1) {
        mySpinner.setSelection(iRound-1);
       };

        //Listener for Rounds Spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                iRound= position+ 1;
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

     //   if (IFirstLoad == 1) {
       //     IPOS = 22;
      //  } else {
      //     IPOS = Pos + 1;
     //  }


        if (!called)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            called = true;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String currentDate = sdf.format(new Date());

       // iRound=iRound+1;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef  = database.getReference().child( Integer.toString(iRound));

        // DatabaseReference myRef = database.getReference();

        // Call Google Maps Activity
        TextView tvmap= (TextView)v.findViewById(R.id.textviewAddress);
        tvmap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Bundle dataBundle = new Bundle();
              //  dataBundle.putInt("Round", IPOS);
                dataBundle.putString("Lat", sLat);
                dataBundle.putString("Long", sLong);
                dataBundle.putString("Ground", sGround);
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });


        // Call Match Report Activity
        TextView tvreport= (TextView)v.findViewById(R.id.textViewREPORT);
        tvreport.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            ListItemActivity1 fragment2 = new ListItemActivity1();
            FragmentManager fragmentManager = getFragmentManager();
            Bundle args = new Bundle();
            args.putInt("Round", iRound);
            fragment2.setArguments(args);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainLayout, fragment2);
            fragmentTransaction.commit();
                }
            });


        // For Listener, get data direct from snapshot
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Lat Long
                sLat= dataSnapshot.child("Lat").getValue(String.class);
                sLong= dataSnapshot.child("Long").getValue(String.class);
                sGround= dataSnapshot.child("Ground").getValue(String.class);

                //Date
                TextView tvDate= (TextView) v.findViewById(R.id.textviewDate);
                tvDate.setText(dataSnapshot.child("Date").getValue(String.class));

                //Times
                TextView tvTime14= (TextView) v.findViewById(R.id.textView14);
                tvTime14.setText("Under 14 : " + dataSnapshot.child("Time14").getValue(String.class));

                TextView tvTime15= (TextView) v.findViewById(R.id.textView15);
                tvTime15.setText("Under 15 : " + dataSnapshot.child("Time15").getValue(String.class));

                TextView tvTime17= (TextView) v.findViewById(R.id.textView17);
                tvTime17.setText("Under 17 : " + dataSnapshot.child("Time17").getValue(String.class));

                TextView tvTimeRes= (TextView) v.findViewById(R.id.textViewres);
                tvTimeRes.setText("Reserves : " + dataSnapshot.child("TimeRes").getValue(String.class));

                TextView tvTimelst= (TextView) v.findViewById(R.id.textViewfirst);
                tvTimelst.setText("1st Grade : " + dataSnapshot.child("Time1").getValue(String.class));


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

