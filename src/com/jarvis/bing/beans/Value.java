package com.jarvis.bing.beans;

public class Value
{
    private String webSearchUrl;

    private String text;

    private String displayText;

    public String getWebSearchUrl ()
    {
        return webSearchUrl;
    }

    public void setWebSearchUrl (String webSearchUrl)
    {
        this.webSearchUrl = webSearchUrl;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getDisplayText ()
    {
        return displayText;
    }

    public void setDisplayText (String displayText)
    {
        this.displayText = displayText;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [webSearchUrl = "+webSearchUrl+", text = "+text+", displayText = "+displayText+"]";
    }
}