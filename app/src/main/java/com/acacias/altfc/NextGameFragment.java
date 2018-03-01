package com.acacias.altfc;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




/**
 * A simple {@link Fragment} subclass.
 */
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
        // return inflater.inflate(R.layout.fragment_history, container, false);

         v = inflater.inflate(R.layout.fragment_next_game, container, false);

       getActivity().setTitle("Next Game");

        IFirstLoad=1;
        IPOS=0;


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

        Spinner mySpinner = (Spinner) v.findViewById(R.id.spRound);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rounds));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
      // mySpinner.setSelection(0);

       Spinner mySpinnerdate = (Spinner) v.findViewById(R.id.spDate);
       ArrayAdapter<String> myAdapterDate = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Date));

        myAdapterDate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerdate.setAdapter(myAdapterDate);

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



    void LoadScreen(int Pos){

        if (IFirstLoad==1) {
            IPOS=0;
        } else {
            IPOS=Pos+1;
        }

        final DatabaseHandler db = new DatabaseHandler(getActivity());
        Match match = db.getMatch(IPOS);

        Spinner mySpinner = (Spinner) v.findViewById(R.id.spRound);

     //   if (IFirstLoad==1) {
            mySpinner.setSelection(match.getRound() - 1);
      //  };

        Spinner mySpinnerDate = (Spinner) v.findViewById(R.id.spDate);
        mySpinnerDate.setSelection(match.getRound() - 1);

       // mySpinner.setSelection(match.getRound() - 1);


        String dtStart = match.getDate();

        String strmonthNbr=dtStart.substring(5,7);
        String strday=dtStart.substring(8,10);
        String stryear=dtStart.substring(0,4);

        String strmonth=null;

        switch (strmonthNbr) {
            case "03":
                strmonth ="March";
                break;
            case "04":
                strmonth ="April";
                break;
            case "05":
                strmonth ="May";
                break;
            case "06":
                strmonth ="June";
                break;
            case "07":
                strmonth ="July";
                break;
            case "08":
                strmonth ="August";
                break;
            case "09":
                strmonth ="September";
                break;
            default:
                strmonth ="January";
                break;
        }

        TextView tvhome = (TextView) v.findViewById(R.id.textViewHome);
        tvhome.setText(match.getHomeTeam());

        TextView tvvisit= (TextView)v.findViewById(R.id.textViewVisit);
        tvvisit.setText(match.getVisitTeam());

        TextView tvground= (TextView)v.findViewById(R.id.textViewGround);
        tvground.setText(match.getGround());

        TextView tvtime1= (TextView)v.findViewById(R.id.textViewfirst);
        tvtime1.setText("1st Grade: " +  match.getTime1());

        TextView tvtime2= (TextView)v.findViewById(R.id.textViewres);
        tvtime2.setText("Res Grade: " + match.getTime2());

        TextView tvtime3= (TextView)v.findViewById(R.id.textViewr17);
        tvtime3.setText("Under 17: " + match.getTime17());

        TextView tvtime4= (TextView)v.findViewById(R.id.textView15);
        tvtime4.setText("Under 15: " + match.getTime15());

        TextView tvtime5= (TextView)v.findViewById(R.id.textView14);
        tvtime5.setText("Under 14: " + match.getTime14());

        String strhomeTeam= match.getHomeTeam();

        if (strhomeTeam.equals("APIA")) {
            ImageView IVLogohome = (ImageView)v.findViewById(R.id.imageViewHOME);
            IVLogohome.setImageResource(R.mipmap.apia_logo);

            ImageView IVVisit = (ImageView)v.findViewById(R.id.imageViewVISIT);
            Context context = IVLogohome.getContext();
            int idl = context.getResources().getIdentifier(match.getlogo(), "mipmap", context.getPackageName());
            IVVisit.setImageResource(idl);
        } else {

            ImageView IVLogohome = (ImageView)v.findViewById(R.id.imageViewHOME);
            Context context = IVLogohome.getContext();
            int idl = context.getResources().getIdentifier(match.getlogo(), "mipmap", context.getPackageName());
            IVLogohome.setImageResource(idl);

            ImageView IVVisit = (ImageView)v.findViewById(R.id.imageViewVISIT);
            IVVisit.setImageResource(R.mipmap.apia_logo);
        }
        IFirstLoad=0;

    };


}
