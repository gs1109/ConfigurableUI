package com.spiderg.viewsDataModel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *    Contains the generic views contents including texts, its sizes, color and list of items for
 *    spinners & radio_buttons.
 */
public class ViewContentsData implements Serializable
{
    @SerializedName("text")
    public String   text;

    @SerializedName("size")
    public int      size;

    @SerializedName("color")
    public String   color;

    @SerializedName("gravity")
    public String   gravity;

    @SerializedName("hint")
    public String   hint;

    @SerializedName("padding")
    public ViewBasicPropertiesData.Margin padding;

    @SerializedName("options")
    public ArrayList<String> options =  new ArrayList<String>();




    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public ViewBasicPropertiesData.Margin getPadding() {
        return padding;
    }

    public void setPadding(ViewBasicPropertiesData.Margin padding) {
        this.padding = padding;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
