package com.spiderg.dynamicViews;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsUtility.AlignmentType;
import com.spiderg.viewsUtility.ICustomView;
import com.spiderg.viewsDataModel.ViewBasicPropertiesData;
import com.spiderg.viewsDataModel.ViewListData;

/**
 *   Base class for the views needs to be generated dynamically...
 */
public class DynamicView implements ICustomView
{

    protected   LinearLayout                parentLayout;
    protected   LinearLayout.LayoutParams   layoutParams;

    private     ViewListData.ViewData       viewData;


    public DynamicView(ViewListData.ViewData viewData, Context context)
    {
        parentLayout    = new LinearLayout(context);
        this.viewData   = viewData;
    }


    /*
    *      Sets the basic views properties of the view...
    */
    protected void setBasicViewsProperties(View view)
    {
        // Setting Contents of the View....
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        // Set height and width of the layout
        layoutParams = new LinearLayout.LayoutParams(
                (int)(viewData.getViewProperties().getWidth() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getViewProperties().getHeight() *  ConfigurableUIApplication.getInstance().SCREEN_DENSITY));

        // Set margins for the views...
        layoutParams.setMargins(
                (int)(getViewMargin(viewData).getLeft()   * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getTop()    * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getRight()  * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getBottom() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY)
        );

        // Set the background color of the view
        view.setBackgroundColor(Color.parseColor(viewData.getViewProperties().getBackground()));

        // Set alignment for the views.....
        switch (viewData.getViewProperties().getAlignment())
        {
            case AlignmentType.CENTER:
                layoutParams.gravity = Gravity.BOTTOM;
                break;
            case AlignmentType.CENTER_HORIZONTAL:
                layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
                break;
            case AlignmentType.CENTER_VERTICAL:
                layoutParams.gravity = Gravity.CENTER_VERTICAL;
                break;
            case AlignmentType.START:
                layoutParams.gravity = Gravity.START;
                break;
            case AlignmentType.END:
                layoutParams.gravity = Gravity.END;
                break;
            case AlignmentType.TOP:
                layoutParams.gravity = Gravity.TOP;
                break;
            case AlignmentType.BOTTOM:
                layoutParams.gravity = Gravity.BOTTOM;
                break;
        }
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }


    protected ViewBasicPropertiesData.Margin getViewMargin(ViewListData.ViewData viewData)
    {
        return viewData.getViewProperties().getMargin();
    }
}
