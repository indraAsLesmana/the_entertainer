package com.emveep.theentertainer.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.emveep.theentertainer.Adapter.RegisterFragment_Adapter;
import com.emveep.theentertainer.R;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public static void start(Activity caller) {
        Intent intent = new Intent(caller, RegisterActivity.class);
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.registery_toolbar);
        setSupportActionBar(toolbar);

        ActionBar action = getSupportActionBar();
        if (action != null){
            action.setDisplayShowTitleEnabled(false);
            action.setDisplayHomeAsUpEnabled(true);
        }

        ViewPager mMain_Pagger = (ViewPager) findViewById(R.id.main_pagger);

        RegisterFragment_Adapter adapter = new RegisterFragment_Adapter(
                getSupportFragmentManager(), this);

        mMain_Pagger.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mMain_Pagger);
    }
}
