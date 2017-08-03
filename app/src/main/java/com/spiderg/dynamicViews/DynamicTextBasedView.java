package com.spiderg.dynamicViews;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsUtility.AlignmentType;
import com.spiderg.viewsDataModel.ViewBasicPropertiesData;
import com.spiderg.viewsDataModel.ViewListData;

/**
 *   Base class for the views needs to be generated dynamically...
 */
public class DynamicTextBasedView extends DynamicView
{

    private     ViewListData.ViewData       viewData;


    public DynamicTextBasedView(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        this.viewData   = viewData;
    }


    /*
     *      Sets the texts based properties of the view...
     */
    protected void setViewsContentProperties(TextView view)
    {
        // Setting Text properties of the View like text, size and color ....
        view.setText(viewData.getContents().getText());
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, viewData.getContents().getSize()
                                                * getApplicationInstance().SCREEN_DENSITY);
        view.setTextColor(Color.parseColor(viewData.getContents().getColor()));
        view.setAllCaps(false);

        setGravity(view);

        // Setting hints for the views
        view.setHint(viewData.getContents().getHint());

        // Setting padding for the views content...
        view.setPadding(
                (int)(getViewPadding().getLeft()   * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewPadding().getTop()    * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewPadding().getRight()  * getApplicationInstance().SCREEN_DENSITY),
                (int)(getViewPadding().getBottom() * getApplicationInstance().SCREEN_DENSITY)
        );
    }


    protected void setGravity(TextView view)
    {
        // Setting Gravity of the texts...  Only Showing these three alignments....
        switch (viewData.getContents().getGravity())
        {
            case AlignmentType.CENTER:
                view.setGravity(Gravity.CENTER);
                break;
            case AlignmentType.CENTER_HORIZONTAL:
                view.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
            case AlignmentType.CENTER_VERTICAL:
                view.setGravity(Gravity.CENTER_VERTICAL);
                break;
            case AlignmentType.START:
            case AlignmentType.LEFT:
                view.setGravity(Gravity.START);
                break;
            case AlignmentType.END:
            case AlignmentType.RIGHT:
                view.setGravity(Gravity.END);
                break;
            case AlignmentType.TOP:
                view.setGravity(Gravity.TOP);
                break;
            case AlignmentType.BOTTOM:
                view.setGravity(Gravity.BOTTOM);
                break;
        }
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
