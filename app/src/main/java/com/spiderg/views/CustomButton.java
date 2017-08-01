package com.spiderg.views;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsDataModel.ViewBasicPropertiesData;
import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the checkBox on the basis of properties passed...
 */
public class CustomButton implements ICustomView
{
    Button                      button;
    LinearLayout                parentLayout;
    LinearLayout.LayoutParams   layoutParams;



    public  CustomButton(ViewListData.ViewData viewData, Context context)
    {
        parentLayout = new LinearLayout(context);
        button       = new Button(context);

        setBasicViewsProperties(viewData);
        setViewsContentProperties(viewData);

        parentLayout.addView(button, layoutParams);
    }


    /*
    *      Sets the basic views properties of the view...
    */
    private void setBasicViewsProperties(ViewListData.ViewData viewData)
    {
        // Setting Contents of the View....
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        layoutParams = new LinearLayout.LayoutParams(
                (int)(viewData.getViewProperties().getWidth() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getViewProperties().getHeight() *  ConfigurableUIApplication.getInstance().SCREEN_DENSITY));
        layoutParams.setMargins(
                (int)(getViewMargin(viewData).getLeft()   * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getTop()    * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getRight()  * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(getViewMargin(viewData).getBottom() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY)
        );

        button.setBackgroundColor(Color.parseColor(viewData.getViewProperties().getBackground()));

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


    /*
     *      Sets the texts properties of the view...
     */
    private void setViewsContentProperties(ViewListData.ViewData viewData)
    {
        // Setting Text properties of the View....
        button.setText(viewData.getContents().getText());
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, viewData.getContents().getSize() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY);
        button.setTextColor(Color.parseColor(viewData.getContents().getColor()));
        button.setAllCaps(false);

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

        button.setHint(viewData.getContents().getHint());
        button.setPadding(
                (int)(viewData.getContents().getPadding().getLeft()   * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getContents().getPadding().getTop()    * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getContents().getPadding().getRight()  * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getContents().getPadding().getBottom() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY)
        );
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }


    private ViewBasicPropertiesData.Margin getViewMargin(ViewListData.ViewData viewData)
    {
        return viewData.getViewProperties().getMargin();
    }
}
