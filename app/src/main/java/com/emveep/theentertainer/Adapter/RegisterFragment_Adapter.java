package com.emveep.theentertainer.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import com.emveep.theentertainer.Fragment.Register_Fragment;
import com.emveep.theentertainer.Fragment.SignIn_Fragment;

/**
 * Created by indraaguslesmana on 3/9/17.
 */

public class RegisterFragment_Adapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Sign In", "Register"};
    private Context mContext;

    private static final int SIGN = 0;
    private static final int REGISTER = 1;

    public RegisterFragment_Adapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case SIGN:
                return new SignIn_Fragment();
            case REGISTER:
                return new Register_Fragment();
            default:
                return new SignIn_Fragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        SpannableString sb = new SpannableString(tabTitles[position]);
        sb.setSpan(null, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
