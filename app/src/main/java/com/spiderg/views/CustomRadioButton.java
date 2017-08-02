package com.spiderg.views;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.spiderg.configurableui.ConfigurableUIApplication;
import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the button on the basis of properties passed...
 */
public class CustomRadioButton extends CustomTextBasedView
{
    private RadioButton radioButton;
    private RadioGroup  radioGroup;
    private Context     mContext;


    public CustomRadioButton(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        mContext     = context;
        radioGroup   = new RadioGroup(context);

        setBasicViewsProperties(radioGroup);
        setRadioButtonOptions(viewData);

        parentLayout.addView(radioGroup, layoutParams);
    }


    private void setRadioButtonOptions(ViewListData.ViewData  viewData)
    {
        for(int i=0; i<viewData.getContents().getOptions().size(); i++)
        {
            createRadioButton(viewData, i);
        }
    }


    /*
     *  Create Radio Buttons based on the text passed.
     */
    private void createRadioButton(ViewListData.ViewData viewData, int index)
    {
        RadioButton radioButton = new RadioButton(mContext);
        setViewsContentProperties(radioButton);
        radioButton.setText(viewData.getContents().getOptions().get(index));
        radioGroup.addView(radioButton);
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }
}
