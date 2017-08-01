package com.spiderg.viewsDataModel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *      Model class to hold all the JSON data related to the views...
 */

public class ViewData implements Serializable
{

    private static ViewData instance = new ViewData();

    private ViewData(){}

    public static ViewData getInstance()
    {
        if(instance == null) {
            instance = new ViewData();
        }

        return instance;
    }

    public void inflateCityListData(ViewData instance)
    {
        this.instance = instance;
    }


    
    @SerializedName("viewType")
    public String      viewType;

    @SerializedName("viewProperties")
    public ViewBasicPropertiesData  viewProperties;

    @SerializedName("contents")
    public ViewContentsData   contents;


    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public ViewBasicPropertiesData getViewProperties() {
        return viewProperties;
    }

    public void setViewProperties(ViewBasicPropertiesData viewProperties) {
        this.viewProperties = viewProperties;
    }

    public ViewContentsData getContents() {
        return contents;
    }

    public void setContents(ViewContentsData contents) {
        this.contents = contents;
    }
}
