package com.emveep.theentertainer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emveep.theentertainer.R;
import com.mancj.materialsearchbar.MaterialSearchBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private MaterialSearchBar searchBar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        searchBar = (MaterialSearchBar) rootView.findViewById(R.id.searchBar);
        searchBar.disableSearch();

        return rootView;
    }

}
