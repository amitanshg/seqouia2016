package com.jarvis.bing.beans;

public class RankingResponse
{
    private Mainline mainline;

    public Mainline getMainline ()
    {
        return mainline;
    }

    public void setMainline (Mainline mainline)
    {
        this.mainline = mainline;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mainline = "+mainline+"]";
    }
}
	