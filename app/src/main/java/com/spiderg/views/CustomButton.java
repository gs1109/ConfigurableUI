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
 *      Generates the button on the basis of properties passed...
 */
public class CustomButton extends CustomTextBasedView
{
    private Button   button;


    public  CustomButton(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        button       = new Button(context);

        setBasicViewsProperties(button);
        setViewsContentProperties(button);

        parentLayout.addView(button, layoutParams);
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }
}
