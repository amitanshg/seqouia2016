package com.jarvis.bing.beans;

public class MyPojo
{
    private RelatedSearches relatedSearches;

    private String _type;

    private Images images;

    private RankingResponse rankingResponse;

    private WebPages webPages;

    public RelatedSearches getRelatedSearches ()
    {
        return relatedSearches;
    }

    public void setRelatedSearches (RelatedSearches relatedSearches)
    {
        this.relatedSearches = relatedSearches;
    }

    public String get_type ()
    {
        return _type;
    }

    public void set_type (String _type)
    {
        this._type = _type;
    }

    public Images getImages ()
    {
        return images;
    }

    public void setImages (Images images)
    {
        this.images = images;
    }

    public RankingResponse getRankingResponse ()
    {
        return rankingResponse;
    }

    public void setRankingResponse (RankingResponse rankingResponse)
    {
        this.rankingResponse = rankingResponse;
    }

    public WebPages getWebPages ()
    {
        return webPages;
    }

    public void setWebPages (WebPages webPages)
    {
        this.webPages = webPages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [relatedSearches = "+relatedSearches+", _type = "+_type+", images = "+images+", rankingResponse = "+rankingResponse+", webPages = "+webPages+"]";
    }
}
	