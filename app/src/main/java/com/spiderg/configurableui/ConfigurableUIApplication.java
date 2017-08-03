package com.spiderg.configurableui;

import android.app.Application;


public class ConfigurableUIApplication extends Application
{
    private     static ConfigurableUIApplication instance;

    public      int      SCREEN_WIDTH;
    public      int      SCREEN_HEIGHT;
    public      float    X_MUTLIPLIER;
    public      float    Y_MULTIPLIER;
    public      float    SCREEN_DENSITY;

    public final String  VIEW_JSON_FILE_NAME  =  "ConfigurableUIJSON.txt";


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
