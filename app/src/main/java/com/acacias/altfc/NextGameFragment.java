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

public class NextGameFragment extends Fragment {

    int  IPOS;
    int  IFirstLoad;
    View v;

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

        Spinner mySpinnerdate = (Spinner) v.findViewById(R.id.spDate);
        ArrayAdapter<String> myAdapterDate = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Date));

        myAdapterDate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerdate.setAdapter(myAdapterDate);

        //Listener for Rounds Spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                LoadScreen(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        //Listener for Dates Spinner
        mySpinnerdate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
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
            //  IPOS=0;
        } else {
            IPOS = Pos + 1;
        }

        final DatabaseHandler db = new DatabaseHandler(getActivity());
        Match match = db.getMatch(IPOS);

        //Set up Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        String sRound = String.valueOf(match.getRound()) ;
        DatabaseReference myRef = database.getReference().child(sRound);
        // DatabaseReference myRef = database.getReference();

// For Listener, get data direct from snapshot
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
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

        //Set Spinner Round
        Spinner mySpinner = (Spinner) v.findViewById(R.id.spRound);
        mySpinner.setSelection(match.getRound() - 1);

        //Set Spinner Date
        Spinner mySpinnerDate = (Spinner) v.findViewById(R.id.spDate);
        mySpinnerDate.setSelection(match.getRound() - 1);

        String dtStart = match.getDate();

        String strmonthNbr = dtStart.substring(5, 7);
        String strmonth = null;

        switch (strmonthNbr) {
            case "03":
                strmonth = "March";
                break;
            case "04":
                strmonth = "April";
                break;
            case "05":
                strmonth = "May";
                break;
            case "06":
                strmonth = "June";
                break;
            case "07":
                strmonth = "July";
                break;
            case "08":
                strmonth = "August";
                break;
            case "09":
                strmonth = "September";
                break;
            default:
                strmonth = "January";
                break;
        }

        TextView tvhome = (TextView) v.findViewById(R.id.textViewHome);
        tvhome.setText(match.getHomeTeam());

        TextView tvvisit = (TextView) v.findViewById(R.id.textViewVisit);
        tvvisit.setText(match.getVisitTeam());

        TextView tvground = (TextView) v.findViewById(R.id.textViewGround);
        tvground.setText(match.getGround());

        TextView tvaddress = (TextView) v.findViewById(R.id.textViewMAP);
        tvaddress.setText(match.getAddress() + " (map)");

        TextView tvtime1 = (TextView) v.findViewById(R.id.textViewfirst);
        tvtime1.setText("1st Grade: " + match.getTime1());

        TextView tvtime2 = (TextView) v.findViewById(R.id.textViewres);
        tvtime2.setText("Reserves : " + match.getTime2());

        TextView tvtime3 = (TextView) v.findViewById(R.id.textViewr17);
        tvtime3.setText("Under 17 : " + match.getTime17());

        TextView tvtime4 = (TextView) v.findViewById(R.id.textView15);
        tvtime4.setText("Under 15 : " + match.getTime15());

        TextView tvtime5 = (TextView) v.findViewById(R.id.textView14);
        tvtime5.setText("Under 14 : " + match.getTime14());

        String strhomeTeam = match.getHomeTeam();

        if (strhomeTeam.equals("APIA")) {
            ImageView IVLogohome = (ImageView) v.findViewById(R.id.imageViewHOME);
            IVLogohome.setImageResource(R.mipmap.apia_logo);

            ImageView IVVisit = (ImageView) v.findViewById(R.id.imageViewVISIT);
            Context context = IVLogohome.getContext();
            int idl = context.getResources().getIdentifier(match.getlogo(), "mipmap", context.getPackageName());
            IVVisit.setImageResource(idl);
        } else {

            ImageView IVLogohome = (ImageView) v.findViewById(R.id.imageViewHOME);
            Context context = IVLogohome.getContext();
            int idl = context.getResources().getIdentifier(match.getlogo(), "mipmap", context.getPackageName());
            IVLogohome.setImageResource(idl);

            ImageView IVVisit = (ImageView) v.findViewById(R.id.imageViewVISIT);
            IVVisit.setImageResource(R.mipmap.apia_logo);
        }
        IFirstLoad = 0;
}


}

