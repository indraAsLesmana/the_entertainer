package com.emveep.theentertainer.Activity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.emveep.theentertainer.R;

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FullscreenActivity";
    private View mRegister, mTake_atour, mAlready_have_account;
    private ImageView imageSwitcher;
    private int[] imageList =
            {R.drawable.image_building1,
                    R.drawable.image_sakura,
                    R.drawable.image_waterfall};

    Animation zoomin, zoomout, zoomtoxy;

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
        imageSwitcher = (ImageView) findViewById(R.id.image_switcher);

        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        zoomtoxy = AnimationUtils.loadAnimation(this, R.anim.zoomtoxy);


        /*imageSwitcher.postDelayed(new Runnable() {
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
        }, 1000);*/

        animate(imageSwitcher, imageList, 0, true);

//        animate2();

        mRegister.setOnClickListener(this);
        mAlready_have_account.setOnClickListener(this);
        mTake_atour.setOnClickListener(this);

//        zoomEffect();
    }

    private void animatex(){
        imageSwitcher.postDelayed(new Runnable() {
            int i = 0;
            int max = imageList.length;
            int min = 0;
            int x = 0;

            @Override
            public void run() {
                i = i % 3;
                imageSwitcher.setBackgroundResource(imageList[i]);
                animate2();

                Random random = new Random();
                x = random.nextInt(max - min + 1);

                switch (x) {
                    case 0:
                        imageSwitcher.setAnimation(zoomtoxy);
                        break;
                    case 1:
                        imageSwitcher.setAnimation(zoomin);
                        break;
                    case 2:
                        imageSwitcher.setAnimation(zoomout);
                        break;
                    default:
                        imageSwitcher.setAnimation(zoomin);
                }
                imageSwitcher.postDelayed(this, 10000);

            }
        }, 1000);
    }
    private void animate2() {
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                ContextCompat.getDrawable(this, R.drawable.image_building1),
                ContextCompat.getDrawable(this, R.drawable.image_waterfall),
                ContextCompat.getDrawable(this, R.drawable.image_sakura)

        });
        td.setCrossFadeEnabled(true);
        imageSwitcher.setImageDrawable(td);
        td.startTransition(9000);

    }

    private void animate(final ImageView imageView,
                         final int images[],
                         final int imageIndex,
                         final boolean forever) {

        //imageView <-- The View which displays the images
        //images[] <-- Holds R references to the images to display
        //imageIndex <-- index of the first image to show in images[]
        //forever <-- If equals true then after the last image it starts all over again with the first image resulting in an infinite loop. You have been warned.

        int fadeInDuration = 100; // Configure time values here
        int timeBetween = 5000;
        int fadeOutDuration = 500;
/*
        imageView.setVisibility(View.VISIBLE);    //Visible or invisible by default - this will apply when the animation ends
        imageView.setImageResource(images[imageIndex]);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); // add this
        fadeIn.setDuration(fadeInDuration);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); // and this
        fadeOut.setStartOffset(fadeInDuration + timeBetween);
        fadeOut.setDuration(fadeOutDuration);*/

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        int mShortAnimationDuration = 5000;

        imageView.setAlpha(0f);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(images[imageIndex]);

        AnimationSet animation = new AnimationSet(false); // change to false
        animation.setRepeatCount(1);
        animation.addAnimation(zoomin);

        imageView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (images.length - 1 > imageIndex) {
                    animate(imageView, images, imageIndex + 1, forever); //Calls itself until it gets to the end of the array
                } else {
                    if (forever == true) {
                        imageView.animate()
                                .alpha(0f)
                                .setDuration(5000)
                                .setListener(null);
                        imageView.setVisibility(View.GONE);
                        animate(imageView, images, 0, forever);  //Calls itself to start the animation all over again in a loop if forever = true
                    }
                }
            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
        });
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

        switch (v.getId()) {
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
