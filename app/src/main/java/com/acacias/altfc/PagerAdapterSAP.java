package com.acacias.altfc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterSAP extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterSAP(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment13SAP tab1 = new TabFragment13SAP();
                return tab1;
            case 1:
                TabFragment12SAP tab2 = new TabFragment12SAP();
                return tab2;
            case 2:
                TabFragment11SAP tab3 = new TabFragment11SAP();
                return tab3;
            case 3:
                TabFragment10SAP tab4 = new TabFragment10SAP();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}