package com.spiderg.views;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the editText on the basis of properties passed...
 */
public class CustomEditText extends CustomTextBasedView
{

    private EditText editText;


    public CustomEditText(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        editText = new EditText(context);

        setBasicViewsProperties(editText);
        setViewsContentProperties(editText);

        parentLayout.addView(editText, layoutParams);
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }

}


