package com.jarvis.bing.beans;

public class Thumbnail
{
    private String height;

    private String width;

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [height = "+height+", width = "+width+"]";
    }
}
			
	