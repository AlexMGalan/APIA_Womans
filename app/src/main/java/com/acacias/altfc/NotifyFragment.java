package com.acacias.altfc;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NotifyFragment extends Fragment {

    Button button1;
    Button button2;
    int igoalAPIA;
    int igoalOpp;

    public NotifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_history, container, false);

        View v = inflater.inflate(R.layout.fragment_notify, container, false);
       // getActivity().setTitle("Notifications");

        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);
        igoalAPIA=0;
        igoalOpp=0;


        getActivity().setTitle("Notifications");
        addListenerNotButton();
        return v;
        //return inflater.inflate(R.layout.result, container, false);
    }

    public void addListenerNotButton() {

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
             //   igoalAPIA=igoalAPIA+1;
               // addNotification();
                addNotification();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View arg0) {
                                           igoalOpp=igoalOpp+1;
                                           addNotification();
                                       }
                                   }
        );

    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.apia_logo_new)
                        .setContentTitle("GOAL!")   //this is the title of notification
                        .setColor(101)
                        .setContentText("APIA " +  igoalAPIA + " SD Raiders " + igoalOpp );
        Intent intent = new Intent(getActivity(), NotifyFragment.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        long[] pattern = {500,500};
        builder.setVibrate(pattern);
        // Add as notification
        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());
    }

}





