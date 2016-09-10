package com.jarvis.bing.beans;

public class Value1
{
    private String contentSize;

    private String contentUrl;

    private String datePublished;

    private String width;

    private String encodingFormat;

    private String hostPageUrl;

    private String hostPageDisplayUrl;

    private String webSearchUrl;

    private String height;

    private Thumbnail thumbnail;

    private InsightsSourcesSummary insightsSourcesSummary;

    private String name;

    private String thumbnailUrl;

    public String getContentSize ()
    {
        return contentSize;
    }

    public void setContentSize (String contentSize)
    {
        this.contentSize = contentSize;
    }

    public String getContentUrl ()
    {
        return contentUrl;
    }

    public void setContentUrl (String contentUrl)
    {
        this.contentUrl = contentUrl;
    }

    public String getDatePublished ()
    {
        return datePublished;
    }

    public void setDatePublished (String datePublished)
    {
        this.datePublished = datePublished;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getEncodingFormat ()
    {
        return encodingFormat;
    }

    public void setEncodingFormat (String encodingFormat)
    {
        this.encodingFormat = encodingFormat;
    }

    public String getHostPageUrl ()
    {
        return hostPageUrl;
    }

    public void setHostPageUrl (String hostPageUrl)
    {
        this.hostPageUrl = hostPageUrl;
    }

    public String getHostPageDisplayUrl ()
    {
        return hostPageDisplayUrl;
    }

    public void setHostPageDisplayUrl (String hostPageDisplayUrl)
    {
        this.hostPageDisplayUrl = hostPageDisplayUrl;
    }

    public String getWebSearchUrl ()
    {
        return webSearchUrl;
    }

    public void setWebSearchUrl (String webSearchUrl)
    {
        this.webSearchUrl = webSearchUrl;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public Thumbnail getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (Thumbnail thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public InsightsSourcesSummary getInsightsSourcesSummary ()
    {
        return insightsSourcesSummary;
    }

    public void setInsightsSourcesSummary (InsightsSourcesSummary insightsSourcesSummary)
    {
        this.insightsSourcesSummary = insightsSourcesSummary;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getThumbnailUrl ()
    {
        return thumbnailUrl;
    }

    public void setThumbnailUrl (String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contentSize = "+contentSize+", contentUrl = "+contentUrl+", datePublished = "+datePublished+", width = "+width+", encodingFormat = "+encodingFormat+", hostPageUrl = "+hostPageUrl+", hostPageDisplayUrl = "+hostPageDisplayUrl+", webSearchUrl = "+webSearchUrl+", height = "+height+", thumbnail = "+thumbnail+", insightsSourcesSummary = "+insightsSourcesSummary+", name = "+name+", thumbnailUrl = "+thumbnailUrl+"]";
    }
}
		