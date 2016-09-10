package com.jarvis.bing.beans;

                 
public class Value2
{
    private String displayUrl;

    private String id;

    private String dateLastCrawled;

    private String name;

    private String snippet;

    private String url;

    public String getDisplayUrl ()
    {
        return displayUrl;
    }

    public void setDisplayUrl (String displayUrl)
    {
        this.displayUrl = displayUrl;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDateLastCrawled ()
    {
        return dateLastCrawled;
    }

    public void setDateLastCrawled (String dateLastCrawled)
    {
        this.dateLastCrawled = dateLastCrawled;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getSnippet ()
    {
        return snippet;
    }

    public void setSnippet (String snippet)
    {
        this.snippet = snippet;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [displayUrl = "+displayUrl+", id = "+id+", dateLastCrawled = "+dateLastCrawled+", name = "+name+", snippet = "+snippet+", url = "+url+"]";
    }
}
	