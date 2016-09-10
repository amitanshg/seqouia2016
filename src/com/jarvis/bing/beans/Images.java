package com.jarvis.bing.beans;

public class Images
{
    private String id;

    private String displayRecipeSourcesBadges;

    private String webSearchUrl;

    private String displayShoppingSourcesBadges;

    private String isFamilyFriendly;

    private Value[] value;

    private String readLink;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDisplayRecipeSourcesBadges ()
    {
        return displayRecipeSourcesBadges;
    }

    public void setDisplayRecipeSourcesBadges (String displayRecipeSourcesBadges)
    {
        this.displayRecipeSourcesBadges = displayRecipeSourcesBadges;
    }

    public String getWebSearchUrl ()
    {
        return webSearchUrl;
    }

    public void setWebSearchUrl (String webSearchUrl)
    {
        this.webSearchUrl = webSearchUrl;
    }

    public String getDisplayShoppingSourcesBadges ()
    {
        return displayShoppingSourcesBadges;
    }

    public void setDisplayShoppingSourcesBadges (String displayShoppingSourcesBadges)
    {
        this.displayShoppingSourcesBadges = displayShoppingSourcesBadges;
    }

    public String getIsFamilyFriendly ()
    {
        return isFamilyFriendly;
    }

    public void setIsFamilyFriendly (String isFamilyFriendly)
    {
        this.isFamilyFriendly = isFamilyFriendly;
    }

    public Value[] getValue ()
    {
        return value;
    }

    public void setValue (Value[] value)
    {
        this.value = value;
    }

    public String getReadLink ()
    {
        return readLink;
    }

    public void setReadLink (String readLink)
    {
        this.readLink = readLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", displayRecipeSourcesBadges = "+displayRecipeSourcesBadges+", webSearchUrl = "+webSearchUrl+", displayShoppingSourcesBadges = "+displayShoppingSourcesBadges+", isFamilyFriendly = "+isFamilyFriendly+", value = "+value+", readLink = "+readLink+"]";
    }
}
