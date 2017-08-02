package com.spiderg.views;

import android.content.Context;
import android.view.View;
import android.widget.Button;
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
