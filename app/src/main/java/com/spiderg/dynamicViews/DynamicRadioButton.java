package com.spiderg.dynamicViews;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.spiderg.viewsDataModel.ViewListData;
import com.spiderg.viewsUtility.AlignmentType;


/**
 *      Generates the button on the basis of properties passed...
 */
public class DynamicRadioButton extends DynamicTextBasedView
{
    private RadioButton radioButton;
    private RadioGroup  radioGroup;
    private Context     mContext;


    public DynamicRadioButton(ViewListData.ViewData viewData, Context context)
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
        setGravity(radioGroup, viewData);
    }


    /*
     *     Setting Gravity for the RadioGroup to align its child items...
     */
    protected void setGravity(RadioGroup view, ViewListData.ViewData viewData)
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
}
