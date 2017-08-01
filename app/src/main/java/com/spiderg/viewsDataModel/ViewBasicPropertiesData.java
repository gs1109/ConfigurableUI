package com.spiderg.viewsDataModel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


/**
 * Contains all the basic view properties which would be common to all view types....
 */
public class ViewBasicPropertiesData implements Serializable
{
    @SerializedName("width")
    public int      width;

    @SerializedName("height")
    public int      height;

    @SerializedName("background")
    public String   background;

    @SerializedName("alignment")
    public String   alignment;

    @SerializedName("margin")
    public Margin   margin;




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

    public Margin getMargin() {
        return margin;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }



    public class Margin implements Serializable
    {
        @SerializedName("left")
        public int      left;

        @SerializedName("right")
        public int      right;

        @SerializedName("top")
        public int      top;

        @SerializedName("bottom")
        public int      bottom;




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

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }
    }

}


