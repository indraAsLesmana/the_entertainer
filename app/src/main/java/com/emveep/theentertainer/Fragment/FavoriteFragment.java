package com.emveep.theentertainer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emveep.theentertainer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends BaseFragment {


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public String getPageTitle() {
        return null;
    }

    @Override
    public void setUICallbacks() {

    }

    @Override
    public int getFragmentLayout() {
        return 0;
    }
}
