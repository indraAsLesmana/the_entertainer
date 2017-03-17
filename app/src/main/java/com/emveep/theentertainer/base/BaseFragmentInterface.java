package com.emveep.theentertainer.base;

import android.view.View;

/**
 * Created by indraaguslesmana on 3/17/17.
 */

public interface BaseFragmentInterface {
    public void updateUI();
    public String getPageTitle();
    public void setUICallbacks();
    public int getFragmentLayout();
    public String getTag();
}
