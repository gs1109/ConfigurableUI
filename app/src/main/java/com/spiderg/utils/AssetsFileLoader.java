package com.spiderg.utils;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.listeners.IFileLoadedListener;

import java.io.IOException;
import java.io.InputStream;


/**
 *      Loads the JSON file from Assets and raise the appropriate callbacks for the listeners...
 */
public class AssetsFileLoader extends AsyncTask<String, String, String>
{
    private     Activity            mContext;
    private     IFileLoadedListener fileLoadedListener;
    private     LoadStatus          loadStatus;

    public enum LoadStatus
    {
        LOAD_SUCCESS,
        LOAD_FAILURE
    }


    public AssetsFileLoader(Activity mContext, IFileLoadedListener fileLoadedListener)
    {
        this.mContext               = mContext;
        this.fileLoadedListener     = fileLoadedListener;
    }


    @Override
    protected String doInBackground(String... params)
    {
        String result = "";

        InputStream input;

        try
        {
            input = mContext.getResources().getAssets().open(ConfigurableUIApplication.getInstance().VIEW_JSON_FILE_NAME);

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            String text = new String(buffer);

            result = text;
            loadStatus = LoadStatus.LOAD_SUCCESS;
        }
        catch (IOException e)
        {
            loadStatus = LoadStatus.LOAD_FAILURE;
            result = e.getMessage();
        }
        catch (Exception e)
        {
            loadStatus = LoadStatus.LOAD_FAILURE;
            result = e.getMessage();
        }

        return result;
    }


    @Override
    protected void onPostExecute(String result)
    {
        super.onPostExecute(result);

        Log.d("JSON", "Response for the Assets File Loader : " + result);

        // Raise the appropriate succes/failure callback on the basis of the LoadStatus variable...
        switch (loadStatus) {
            case LOAD_SUCCESS:
                fileLoadedListener.onFileLoadSuccess(result);
                break;
            case LOAD_FAILURE:
            default:
                fileLoadedListener.onFileLoadError(result);
                break;
        }
    }
}