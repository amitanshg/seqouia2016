package com.jarvis.bing.beans;

public class RelatedSearches
{
    private String id;

    private Value[] value;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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
        return "ClassPojo [id = "+id+", value = "+value+"]";
    }
}
			
	