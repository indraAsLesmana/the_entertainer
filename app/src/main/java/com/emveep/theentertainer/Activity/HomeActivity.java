package com.emveep.theentertainer.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.emveep.theentertainer.Adapter.HomePagerAdapter;
import com.emveep.theentertainer.Fragment.FavoriteFragment;
import com.emveep.theentertainer.Fragment.HomeFragment;
import com.emveep.theentertainer.Fragment.NotifFragment;
import com.emveep.theentertainer.Fragment.ProfileFragment;
import com.emveep.theentertainer.Fragment.ShopFragment;
import com.emveep.theentertainer.R;
import com.emveep.theentertainer.Utility.HomeButton_effect;
import com.mancj.materialsearchbar.MaterialSearchBar;

public class HomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private NotifFragment notifFragment;
    private ProfileFragment profileFragment;
    private ShopFragment shopFragment;

    private MaterialSearchBar searchBar;
    private Toolbar toolbar;

    private ViewPager viewPager;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    disableHomeTitle();
                    viewPager.setCurrentItem(HomePagerAdapter.HOME_FRAGMENT);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(HomePagerAdapter.NOTIF_FRAGMENT);
                    return true;
                case R.id.navigation_favorite:
                    viewPager.setCurrentItem(HomePagerAdapter.FAVORITE_FRAGMENT);
                    return true;
                case R.id.navigation_profile:
                    viewPager.setCurrentItem(HomePagerAdapter.PROFILE_FRAGMENT);
                    return true;
                case R.id.navigation_shoping:
                    viewPager.setCurrentItem(HomePagerAdapter.SHOP_FRAGMENT);
                    return true;
                default:
                    viewPager.setCurrentItem(HomePagerAdapter.HOME_FRAGMENT);
            }
            return false;
        }

    };

    public static void start(Activity caller) {
        Intent intent = new Intent(caller, HomeActivity.class);
        caller.startActivity(intent);
    }

    private void showSearchBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
            searchBar.setVisibility(View.VISIBLE);
        }
    }

    private void disableSearchBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            searchBar.setVisibility(View.GONE);
            actionBar.show();
        }
    }

    private void disableHomeTitle(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * search bar library
         * */
        /*searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setVisibility(View.GONE);*/

        viewPager = (ViewPager) findViewById(R.id.home_pagger);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        HomeButton_effect.disableShiftMode(navigation, this);


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setupViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());

        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        notifFragment = new NotifFragment();
        profileFragment = new ProfileFragment();
        shopFragment = new ShopFragment();

        adapter.addFragment(homeFragment); // fragment 0
        adapter.addFragment(favoriteFragment); // fragment 1
        adapter.addFragment(notifFragment); // fragment 2
        adapter.addFragment(profileFragment); // fragment 3
        adapter.addFragment(shopFragment); // fragment 4

        viewPager.setAdapter(adapter);
    }

}
