package com.spiderg.configurableui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.spiderg.views.ViewGeneratorFactory;


/*
 *  Class which generates the views based on the request made to the factory class...
 */
public class MainScreen extends Activity
{
    RelativeLayout  parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        initViews();

        generateViews();
    }


    /*
     *  Initialise the reference of the views in the layout...
     */
    private void initViews()
    {
        parentView     = (RelativeLayout) findViewById(R.id.rl_activity_main_screen_parent);
    }


    /*
     *    Generate the views dynamically based on the JSON data for the view...
     */
    private void generateViews()
    {
        View childView = ViewGeneratorFactory.getDynamicView(1, MainScreen.this);

        if(childView != null)
        {
            parentView.addView(childView);
        }
    }

}
