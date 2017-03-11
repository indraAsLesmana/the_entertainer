package com.emveep.theentertainer.Activity;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.Toast;

import com.emveep.theentertainer.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import cn.carbs.android.autozoominimageview.library.AutoZoomInImageView;

import static com.emveep.theentertainer.R.anim.zoomin;
import static com.emveep.theentertainer.R.anim.zoomout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "FullscreenActivity";
    private View mRegister, mTake_atour, mAlready_have_account;
    private ImageSwitcher imageSwitcher;
    private int [] imageList =
            {R.drawable.image_building1,
             R.drawable.image_sakura,
             R.drawable.image_waterfall};

    Animation zoomin, zoomout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mRegister = findViewById(R.id.register);
        mAlready_have_account = findViewById(R.id.already_have_account);
        mTake_atour = findViewById(R.id.take_a_tour);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.image_switcher);

        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);


        imageSwitcher.postDelayed(new Runnable() {
            int i = 0;
            int max = imageList.length;
            int min = 0;

            public void run() {
                i = i % 3;
                Random random = new Random();
                imageSwitcher.setBackgroundResource(imageList[i]);

                if(i == random.nextInt(max - min + 1) + min){
                    Log.d(TAG, "run: TRUE ----;");
                 imageSwitcher.setAnimation(zoomin); imageSwitcher.startAnimation(zoomin);
                }else {
                    Log.d(TAG, "run: FALSE ----;");
                    imageSwitcher.setAnimation(zoomout); imageSwitcher.startAnimation(zoomout);
                }
                imageSwitcher.postDelayed(this, 10000);
                i++;
            }
        }, 1000);

        mRegister.setOnClickListener(this);
        mAlready_have_account.setOnClickListener(this);
        mTake_atour.setOnClickListener(this);

//        zoomEffect();
    }



    /*private void zoomEffect() {
        final AutoZoomInImageView auto_zoomin_image_view =
                (AutoZoomInImageView) findViewById(R.id.auto_zoomin_image_view);
        auto_zoomin_image_view.post(new Runnable() {
            @Override
            public void run() {

                auto_zoomin_image_view.init()
                        .setScaleDelta(0.3f)//放大的系数是原来的（1 + 0.2）倍 Import dari CHina he he
                        .setDurationMillis(10000)
                        .setOnZoomListener(new AutoZoomInImageView.OnZoomListener() {
                            @Override
                            public void onStart(View view) {

                            }

                            @Override
                            public void onUpdate(View view, float progress) {

                            }

                            @Override
                            public void onEnd(View view) {
                                Log.d(TAG, "onEnd: -------END");
                                auto_zoomin_image_view.setBackgroundResource(R.drawable.image_building2);
                                zoomEffect();
                            }
                        })
                        .start(1000);
            }
        });

    }*/

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.already_have_account:
                // TODO : create sign
                Toast.makeText(this, "todo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.register:
                // TODO: create form
                RegisterActivity.start(this);

                break;
            case R.id.take_a_tour:
                // TODO: take a tour
                HomeActivity.start(this);
                break;
            default:
                break;

        }

    }
}
