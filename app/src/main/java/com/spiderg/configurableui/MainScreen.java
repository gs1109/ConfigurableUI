package com.spiderg.configurableui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;

import com.spiderg.viewsDataModel.ViewListData;
import com.spiderg.viewsUtility.AlignmentType;
import com.spiderg.viewsUtility.ViewGeneratorFactory;


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
        for(int i=0; i<ViewListData.getInstance().getView_Rows().size(); i++ )
        {
            View childView = ViewGeneratorFactory.getDynamicView(i, MainScreen.this);

            if(childView != null)
            {
                childView.setId(i);

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if (i > 0)
                {
                    params.addRule(RelativeLayout.BELOW, i - 1);
                }

                alignViews(getViewAlignment(i), params);
                childView.setLayoutParams(params);

                parentView.addView(childView);
            }
        }
    }


    /*
     *   Align the views on the basis of layout_gravity value in the JSON...
     */
    private void alignViews(String gravity, RelativeLayout.LayoutParams params)
    {
        switch (gravity)
        {
            case AlignmentType.CENTER:
                params.addRule(RelativeLayout.CENTER_IN_PARENT);
                break;
            case AlignmentType.CENTER_HORIZONTAL:
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case AlignmentType.CENTER_VERTICAL:
                params.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case AlignmentType.START:
            case AlignmentType.LEFT:
                params.addRule(RelativeLayout.ALIGN_PARENT_START);
                break;
            case AlignmentType.END:
            case AlignmentType.RIGHT:
                params.addRule(RelativeLayout.ALIGN_PARENT_END);
                break;
            case AlignmentType.TOP:
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                break;
            case AlignmentType.BOTTOM:
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
        }
    }


    private String getViewAlignment(int i)
    {
        return ViewListData.getInstance().getView_Rows().get(i).getViewProperties().getAlignment();
    }



}
