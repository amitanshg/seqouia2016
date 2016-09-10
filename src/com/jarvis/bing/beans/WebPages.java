package com.jarvis.bing.beans;

public class WebPages
{
    private String webSearchUrl;

    private String totalEstimatedMatches;

    private Value[] value;

    public String getWebSearchUrl ()
    {
        return webSearchUrl;
    }

    public void setWebSearchUrl (String webSearchUrl)
    {
        this.webSearchUrl = webSearchUrl;
    }

    public String getTotalEstimatedMatches ()
    {
        return totalEstimatedMatches;
    }

    public void setTotalEstimatedMatches (String totalEstimatedMatches)
    {
        this.totalEstimatedMatches = totalEstimatedMatches;
    }

    public Value[] getValue ()
    {
        return value;
    }

    public void setValue (Value[] value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [webSearchUrl = "+webSearchUrl+", totalEstimatedMatches = "+totalEstimatedMatches+", value = "+value+"]";
    }
}