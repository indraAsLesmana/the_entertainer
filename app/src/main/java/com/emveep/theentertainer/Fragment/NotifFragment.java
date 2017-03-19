package com.emveep.theentertainer.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emveep.theentertainer.Activity.HomeActivity;
import com.emveep.theentertainer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotifFragment extends Fragment {

    private ActionBar actionBar;
    private Context mContext;

    public NotifFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mContext instanceof HomeActivity){
            actionBar = ((HomeActivity) mContext).getSupportActionBar();
            if (actionBar != null){
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setTitle(R.string.title_notifications);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        actionBar.setDisplayShowTitleEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notif, container, false);

        return rootView;
    }

}
