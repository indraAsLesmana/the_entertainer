package com.emveep.theentertainer.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indraaguslesmana on 3/13/17.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    public static final int HOME_FRAGMENT = 0;
    public static final int NOTIF_FRAGMENT = 1;
    public static final int FAVORITE_FRAGMENT = 2;
    public static final int PROFILE_FRAGMENT = 3;
    public static final int SHOP_FRAGMENT = 4;

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public HomePagerAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}


