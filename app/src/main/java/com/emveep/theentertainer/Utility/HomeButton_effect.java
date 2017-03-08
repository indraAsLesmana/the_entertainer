package com.emveep.theentertainer.Utility;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;

import java.lang.reflect.Field;


/**
 * this helper make disable animation on Home Button menu, coused by google on documentation
 * not include handling disabling effect animation.
 * Detail fix this problem :
 * http://stackoverflow.com/questions/40176244/how-to-disable-bottomnavigationview-shift-mode
 * */

public class HomeButton_effect {
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(true);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());

                /**
                 * how to disable title links:
                 * http://stackoverflow.com/questions/40183239/remove-bottomnavigationview-labels
                 * */
               /* AppCompatImageView icon = (AppCompatImageView) item.getChildAt(0);
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) icon.getLayoutParams();
                params.gravity = Gravity.CENTER;*/
            }

        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}