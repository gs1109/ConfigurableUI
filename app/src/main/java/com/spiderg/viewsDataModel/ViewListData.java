package com.spiderg.viewsDataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *    Model class to hold all the JSON data related to the views...
 */
public class ViewListData implements Serializable
{

    private static ViewListData instance = new ViewListData();

    private ViewListData(){}

    public static ViewListData getInstance()
    {
        if(instance == null) {
            instance = new ViewListData();
        }

        return instance;
    }

    public void inflateViewsData(ViewListData instance)
    {
        this.instance = instance;
    }

    @SerializedName("view_rows")
    @Expose
    public ArrayList<ViewData> view_rows = new ArrayList<ViewData>();



    public ArrayList<ViewData> getView_Rows() {
        return view_rows;
    }

    public void setView_rows(ArrayList<ViewData> view_rows) {
        this.view_rows = view_rows;
    }



    public class ViewData implements Serializable
    {
        @SerializedName("viewType")
        public String viewType;

        @SerializedName("viewProperties")
        public ViewBasicPropertiesData viewProperties;

        @SerializedName("contents")
        public ViewContentsData contents;


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
}
