package com.spiderg.configurableui;

import android.app.Application;

/**
 * Created by Gaurav on 01/08/17.
 */

public class ConfigurableUIApplication extends Application
{
    private     static ConfigurableUIApplication instance;

    public      int      SCREEN_WIDTH;
    public      int      SCREEN_HEIGHT;
    public      float    X_MUTLIPLIER;
    public      float    Y_MULTIPLIER;
    public      float    SCREEN_DENSITY;

    public      String   VIEW_JSON_FILE_NAME  =  "ConfigurableUIJSON.txt";


    public static synchronized ConfigurableUIApplication getInstance()
    {
        if (instance == null)
        {
            instance = new ConfigurableUIApplication();
        }
        return instance;
    }


    @Override
    public void onCreate()
    {
        super.onCreate();


    }
}
