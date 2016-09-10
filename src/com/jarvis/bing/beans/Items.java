package com.jarvis.bing.beans;

public class Items
{
    private Value value;

    private String answerType;

    public Value getValue ()
    {
        return value;
    }

    public void setValue (Value value)
    {
        this.value = value;
    }

    public String getAnswerType ()
    {
        return answerType;
    }

    public void setAnswerType (String answerType)
    {
        this.answerType = answerType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", answerType = "+answerType+"]";
    }
}
		