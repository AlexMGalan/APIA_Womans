package com.acacias.altfc;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;


public class SquadsFragmentSAP extends Fragment {


    public SquadsFragmentSAP() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_history, container, false);

        View v = inflater.inflate(R.layout.fragment_squads_sap, container, false);
        getActivity().setTitle("2020 SAP Squads");

        TabLayout tabLayoutSAP = (TabLayout) v.findViewById(R.id.tab_layoutSAP);
        tabLayoutSAP.addTab(tabLayoutSAP.newTab().setText("Under 13"));
        tabLayoutSAP.addTab(tabLayoutSAP.newTab().setText("Under 12"));
        tabLayoutSAP.addTab(tabLayoutSAP.newTab().setText("Under 11"));
        tabLayoutSAP.addTab(tabLayoutSAP.newTab().setText("Under 10"));
        tabLayoutSAP.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPagerSAP = (ViewPager) v.findViewById(R.id.pagerSAP);
        final PagerAdapterSAP adapterSAP = new PagerAdapterSAP
                (((AppCompatActivity)getActivity()).getSupportFragmentManager(), tabLayoutSAP.getTabCount());
        viewPagerSAP.setAdapter(adapterSAP);
        viewPagerSAP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutSAP));
        tabLayoutSAP.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerSAP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;

    }

}
