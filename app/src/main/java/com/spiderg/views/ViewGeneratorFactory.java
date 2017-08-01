package com.spiderg.views;

import android.content.Context;
import android.view.View;

import com.spiderg.viewsDataModel.ViewListData;

/**
 * Created by 9tailstudios on 01/08/17.
 */

public class ViewGeneratorFactory
{
    public static View getDynamicView(int index, Context context)
    {
        if(ViewListData.getInstance().getView_Rows().get(index).getViewType().equalsIgnoreCase("Button"))
        {
            CustomButton  button = new CustomButton(ViewListData.getInstance().getView_Rows().get(index), context);

            return button.getView();
        }


        // Incompatible View Type
        return null;
    }
}
