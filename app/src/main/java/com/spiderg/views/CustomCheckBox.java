package com.spiderg.views;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the checkBox on the basis of properties passed...
 */
public class CustomCheckBox extends CustomTextBasedView
{
    private CheckBox checkBox;


    public  CustomCheckBox(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        checkBox = new CheckBox(context);

        setBasicViewsProperties(checkBox);
        setViewsContentProperties(checkBox);

        parentLayout.addView(checkBox, layoutParams);
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }

}
