package com.spiderg.views;

import android.content.Context;
import android.view.View;

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
            return new CustomButton(getViewDataAtIndex(index), context).getView();
        }
        else if(isEditText(index))
        {
            return new CustomEditText(getViewDataAtIndex(index), context).getView();
        }
        else if(isCheckBox(index))
        {
            return new CustomCheckBox(getViewDataAtIndex(index), context).getView();
        }
        else if(isRadioButton(index))
        {
            return new CustomRadioButton(getViewDataAtIndex(index), context).getView();
        }
        else if(isSpinner(index))
        {
            return new CustomEditText(getViewDataAtIndex(index), context).getView();
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
