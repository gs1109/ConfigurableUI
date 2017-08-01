package com.spiderg.views;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsDataModel.ViewBasicPropertiesData;
import com.spiderg.viewsDataModel.ViewListData;

/**
 *   Base class for the views needs to be generated dynamically...
 */
public class CustomTextBasedView extends CustomView
{
    private     ViewListData.ViewData       viewData;


    public CustomTextBasedView(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        this.viewData   = viewData;
    }


    /*
     *      Sets the texts based properties of the view...
     */
    protected void setViewsContentProperties(TextView view)
    {
        // Setting Text properties of the View....
        view.setText(viewData.getContents().getText());
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, viewData.getContents().getSize() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY);
        view.setTextColor(Color.parseColor(viewData.getContents().getColor()));
        view.setAllCaps(false);

        // Setting Gravity of the texts...  Only Showing these three alignments....
        switch (viewData.getContents().getGravity())
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

        view.setHint(viewData.getContents().getHint());
        view.setPadding(
                (int)(getViewPadding().getLeft()   * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewPadding().getTop()    * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewPadding().getRight()  * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewPadding().getBottom() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY)
        );
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }


    private ViewBasicPropertiesData.Margin getViewPadding()
    {
        return viewData.getContents().getPadding();
    }
}
