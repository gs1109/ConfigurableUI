package com.spiderg.views;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the button on the basis of properties passed...
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
                (int)(viewData.getViewProperties().getMargin().getLeft()   * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getViewProperties().getMargin().getTop()    * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getViewProperties().getMargin().getRight()  * ConfigurableUIApplication.getInstance().SCREEN_DENSITY),
                (int)(viewData.getViewProperties().getMargin().getBottom() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY)
        );

        button.setBackgroundColor(Color.parseColor(viewData.getViewProperties().getBackground()));

        if(viewData.getViewProperties().getAlignment().equalsIgnoreCase("CENTER"))
        {
            layoutParams.gravity = Gravity.CENTER;
        }
        else if(viewData.getViewProperties().getAlignment().equalsIgnoreCase("CENTER_VERTICAL"))
        {
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
        }
        else if(viewData.getViewProperties().getAlignment().equalsIgnoreCase("CENTER_HORIZONTAL"))
        {
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
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
        if(viewData.getContents().getGravity().equalsIgnoreCase("CENTER"))
        {
            button.setGravity(Gravity.CENTER);
        }
        else if(viewData.getContents().getGravity().equalsIgnoreCase("CENTER_VERTICAL"))
        {
            button.setGravity(Gravity.CENTER_VERTICAL);
        }
        else if(viewData.getContents().getGravity().equalsIgnoreCase("CENTER_HORIZONTAL"))
        {
            button.setGravity(Gravity.CENTER_HORIZONTAL);
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
}
