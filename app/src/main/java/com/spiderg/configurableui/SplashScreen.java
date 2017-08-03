package com.spiderg.configurableui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.spiderg.listeners.IFileLoadedListener;
import com.spiderg.utils.AssetsFileLoader;
import com.spiderg.viewsDataModel.ViewListData;
import com.spiderg.viewsUtility.OrientationType;

import org.json.JSONObject;

import java.lang.ref.WeakReference;


/*
 *    Launcher activity where we load the JSON file and deserialize it to the specific classes.
 *    And once done, we traverse to the MainScreen activity after a pause...
 */
public class SplashScreen extends Activity
{

    private final int  SPLASH_TIMEOUT = 2000; // timeout period after which the screen should
                                              // traverse from Splash to Main screen

    private static class CustomHandler extends Handler
    {
        private final WeakReference<SplashScreen> mActivity;

        public CustomHandler(SplashScreen activity)
        {
            mActivity = new WeakReference<SplashScreen>(activity);
        }
    }

    private final CustomHandler mHandler = new CustomHandler(this);



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        setDeviceSpecificConstants();

        readViewDataJSONFile();
    }


    /*
     *      Setting the height and width constants for the current screen
     *      which would be used in setting sizes of view independently of pixels.
     */
    private void setDeviceSpecificConstants()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        getApplicationInstance().SCREEN_WIDTH   = (int)   metrics.widthPixels;
        getApplicationInstance().SCREEN_HEIGHT  = (int)   metrics.heightPixels;
        getApplicationInstance().X_MUTLIPLIER   = (float) metrics.widthPixels  / 320;
        getApplicationInstance().Y_MULTIPLIER   = (float) metrics.heightPixels / 480;
        getApplicationInstance().SCREEN_DENSITY = (float) metrics.density;
    }


    /*
     *  Start the asynctask to read the view's JSON file from the assets folder..
     */
    private void readViewDataJSONFile()
    {
        AssetsFileLoader cityTask = new AssetsFileLoader(SplashScreen.this,
                getApplicationInstance().VIEW_JSON_FILE_NAME,
                new IFileLoadedListener()
                {
                    @Override
                    public void onFileLoadSuccess(String response)
                    {
                        try
                        {
                            Gson gson = new Gson();
                            ViewListData.getInstance().inflateViewsData(gson.fromJson(response,
                                                                            ViewListData.class));

                            generateDummyView();
                            // Open the Main screen as data has been inflated to the model class...
                            openMainScreen();
                        }
                        catch (Exception e)
                        {
                            showErrorMessage(getResources().getString(R.string.invalid_json));
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFileLoadError(String error)
                    {
                        showErrorMessage(getResources().getString(R.string.file_loading_error));
                    }
        });

        cityTask.execute();
    }


    /*
     *  Opens the Main screen after the timeout period
     */
    private void openMainScreen()
    {
        mHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashScreen.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }


    /*
     * There is an ugly hack here as RelativeLayout.Layoutparams doesn't work properly and
     * it doesn't align the second view in the second row, rather than keep it in the first
     * row itself.  So, due to time constraint, adding one dummy identical view upfront in
     * the JSON. There are few people on stackoverflow who are already facing this.
     */
    private void generateDummyView()
    {
        if(!OrientationType.HORIZONTAL.equalsIgnoreCase(ViewListData.getInstance().orientation))
        {
            ViewListData.ViewData view = ViewListData.getInstance().getView_Rows().get(0);
            ViewListData.getInstance().getView_Rows().add(0, view);
        }
    }


    /*
     *   Shows error message in case of JSON exception or IO exception while reading file from
     *   assets...
     */
    private void showErrorMessage(String errorMsg)
    {
        Toast.makeText(SplashScreen.this, errorMsg, Toast.LENGTH_LONG).show();
    }


    private ConfigurableUIApplication getApplicationInstance()
    {
        return ConfigurableUIApplication.getInstance();
    }

}
