package com.spiderg.viewsDataModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Gaurav on 01/08/17.
 */

public class ViewBasicProperties implements Serializable
{
    @SerializedName("width")
    public int width;

    @SerializedName("height")
    public int height;

    @SerializedName("background")
    public String background;

    @SerializedName("alignment")
    public String alignment;

    @SerializedName("margin")
    public String margin;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }



    public class Margin implements Serializable
    {
        @SerializedName("left")
        public int left;

        @SerializedName("right")
        public int right;

        @SerializedName("top")
        public String top;

        @SerializedName("bottom")
        public String bottom;


        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getBottom() {
            return bottom;
        }

        public void setBottom(String bottom) {
            this.bottom = bottom;
        }
    }

}


