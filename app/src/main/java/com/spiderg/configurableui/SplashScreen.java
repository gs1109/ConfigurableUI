package com.spiderg.configurableui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

/**
 * Created by Gaurav on 01/08/17.
 */

public class SplashScreen extends Activity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        setDeviceSpecificConstants();
    }


    /*
     *      Setting the height and width constants for the current screen
     *      which would be used in setting sizes of view independently of pixels.
     */
    private void setDeviceSpecificConstants()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ConfigurableUIApplication.getInstance().SCREEN_WIDTH   = (int)   metrics.widthPixels;
        ConfigurableUIApplication.getInstance().SCREEN_HEIGHT  = (int)   metrics.heightPixels;
        ConfigurableUIApplication.getInstance().X_MUTLIPLIER   = (float) metrics.widthPixels  / 320;
        ConfigurableUIApplication.getInstance().Y_MULTIPLIER   = (float) metrics.heightPixels / 480;
        ConfigurableUIApplication.getInstance().SCREEN_DENSITY = (float) metrics.density;
    }

}
