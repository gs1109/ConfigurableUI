package com.spiderg.viewsUtility;

import android.content.Context;
import android.view.View;

import com.spiderg.dynamicViews.DynamicButton;
import com.spiderg.dynamicViews.DynamicCheckBox;
import com.spiderg.dynamicViews.DynamicEditText;
import com.spiderg.dynamicViews.DynamicRadioButton;
import com.spiderg.dynamicViews.DynamicSpinner;
import com.spiderg.viewsDataModel.ViewListData;

/**
 *   Factory class which generates the View on the basis of the view_type parameter in the JSON...
 */
public class ViewGeneratorFactory
{

    public static View getDynamicView(int index, Context context)
    {
        if(isButton(index))
        {
            return new DynamicButton(getViewDataAtIndex(index), context).getView();
        }
        else if(isEditText(index))
        {
            return new DynamicEditText(getViewDataAtIndex(index), context).getView();
        }
        else if(isCheckBox(index))
        {
            return new DynamicCheckBox(getViewDataAtIndex(index), context).getView();
        }
        else if(isRadioButton(index))
        {
            return new DynamicRadioButton(getViewDataAtIndex(index), context).getView();
        }
        else if(isSpinner(index))
        {
            return new DynamicSpinner(getViewDataAtIndex(index), context).getView();
        }

        // Incompatible View Type
        return null;
    }


    private static ViewListData.ViewData getViewDataAtIndex(int index)
    {
        return ViewListData.getInstance().getView_Rows().get(index);
    }


    private static boolean isEditText(int index)
    {
        return ViewType.EDITTEXT.equalsIgnoreCase(getViewDataAtIndex(index).getViewType());
    }


    private static boolean isButton(int index)
    {
        return ViewType.BUTTON.equalsIgnoreCase(getViewDataAtIndex(index).getViewType());
    }


    private static boolean isRadioButton(int index)
    {
        return ViewType.RADIO_BUTTON.equalsIgnoreCase(getViewDataAtIndex(index).getViewType());
    }


    private static boolean isCheckBox(int index)
    {
        return ViewType.CHECKBOX.equalsIgnoreCase(getViewDataAtIndex(index).getViewType());
    }


    private static boolean isSpinner(int index)
    {
        return ViewType.SPINNER.equalsIgnoreCase(getViewDataAtIndex(index).getViewType());
    }

}
