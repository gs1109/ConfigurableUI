package com.spiderg.dynamicViews;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsUtility.AlignmentType;
import com.spiderg.viewsUtility.ICustomView;
import com.spiderg.viewsDataModel.ViewBasicPropertiesData;
import com.spiderg.viewsDataModel.ViewListData;

/**
 *   Base class for the views which needs to be generated dynamically...
 */
public class DynamicView implements ICustomView
{

    protected   RelativeLayout                parentLayout;
    protected   RelativeLayout.LayoutParams   layoutParams;

    private     ViewListData.ViewData         viewData;


    public DynamicView(ViewListData.ViewData viewData, Context context)
    {
        parentLayout    = new RelativeLayout(context);
        this.viewData   = viewData;
    }


    /*
    *      Sets the basic views properties of the view...
    */
    protected void setBasicViewsProperties(View view)
    {
        // Set height and width of the layout
        layoutParams = new RelativeLayout.LayoutParams(
                (int)(getViewProperties().getWidth()  * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewProperties().getHeight() * getApplicationInstance().SCREEN_DENSITY));

        // Set margins for the views...
        layoutParams.setMargins(
                (int)(getViewMargin(viewData).getLeft()  * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getTop()   * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getRight() * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getBottom()* getApplicationInstance().SCREEN_DENSITY)
        );

        // Set the background color of the view
        view.setBackgroundColor(Color.parseColor(getViewProperties().getBackground()));

        setLayoutGravity();
    }


    /*
     *   Setting layout gravity of the view...
     */
    protected void setLayoutGravity()
    {
        // Set alignment for the views.....
        switch (getViewProperties().getAlignment())
        {
            case AlignmentType.CENTER:
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                break;
            case AlignmentType.CENTER_HORIZONTAL:
                layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case AlignmentType.CENTER_VERTICAL:
                layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case AlignmentType.LEFT:
            case AlignmentType.START:
                layoutParams.addRule(RelativeLayout.ALIGN_START);
                break;
            case AlignmentType.RIGHT:
            case AlignmentType.END:
                layoutParams.addRule(RelativeLayout.ALIGN_END);
                break;
        }
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }


    protected ConfigurableUIApplication getApplicationInstance()
    {
        return ConfigurableUIApplication.getInstance();
    }


    private ViewBasicPropertiesData getViewProperties()
    {
        return viewData.getViewProperties();
    }


    private ViewBasicPropertiesData.Margin getViewMargin(ViewListData.ViewData viewData)
    {
        return getViewProperties().getMargin();
    }
}
