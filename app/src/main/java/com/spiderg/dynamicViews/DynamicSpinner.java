package com.spiderg.dynamicViews;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.spiderg.viewsDataModel.ViewListData;


/**
 *      Generates the button on the basis of properties passed...
 */
public class DynamicSpinner extends DynamicTextBasedView
{
    private Spinner     spinner;
    private Context     mContext;


    public DynamicSpinner(ViewListData.ViewData viewData, Context context)
    {
        super(viewData, context);

        mContext  = context;
        spinner   = new Spinner(context);

        setBasicViewsProperties(spinner);
        setDropdownItems(viewData);

        parentLayout.addView(spinner, layoutParams);
    }


    /*
    *  Populated the dropdown items based on the options available in the JSON..
    */
    private void setDropdownItems(ViewListData.ViewData  viewData)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_dropdown_item_1line, viewData.getContents().getOptions());

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }


    @Override
    public View getView()
    {
        return parentLayout;
    }
}
