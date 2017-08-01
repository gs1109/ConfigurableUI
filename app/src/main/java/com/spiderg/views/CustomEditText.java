package com.spiderg.views;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the editText on the basis of properties passed...
 */
public class CustomEditText implements ICustomView
{
    EditText                    editText;
    LinearLayout                parentLayout;
    LinearLayout.LayoutParams   layoutParams;



    public CustomEditText(ViewListData.ViewData viewData, Context context)
    {
        parentLayout    = new LinearLayout(context);
        editText        = new EditText(context);

        setBasicViewsProperties(viewData);
        setViewsContentProperties(viewData);

        parentLayout.addView(editText, layoutParams);
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

        editText.setBackgroundColor(Color.parseColor(viewData.getViewProperties().getBackground()));

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
        editText.setText(viewData.getContents().getText());
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, viewData.getContents().getSize() * ConfigurableUIApplication.getInstance().SCREEN_DENSITY);
        editText.setTextColor(Color.parseColor(viewData.getContents().getColor()));
        editText.setAllCaps(false);

        // Setting Gravity of the texts...  Only Showing these three alignments....
        if(viewData.getContents().getGravity().equalsIgnoreCase("CENTER"))
        {
            editText.setGravity(Gravity.CENTER);
        }
        else if(viewData.getContents().getGravity().equalsIgnoreCase("CENTER_VERTICAL"))
        {
            editText.setGravity(Gravity.CENTER_VERTICAL);
        }
        else if(viewData.getContents().getGravity().equalsIgnoreCase("CENTER_HORIZONTAL"))
        {
            editText.setGravity(Gravity.CENTER_HORIZONTAL);
        }

        editText.setHint(viewData.getContents().getHint());
        editText.setPadding(
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
