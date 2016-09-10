package com.jarvis.bing.beans;

public class InsightsSourcesSummary
{
    private String recipeSourcesCount;

    private String shoppingSourcesCount;

    public String getRecipeSourcesCount ()
    {
        return recipeSourcesCount;
    }

    public void setRecipeSourcesCount (String recipeSourcesCount)
    {
        this.recipeSourcesCount = recipeSourcesCount;
    }

    public String getShoppingSourcesCount ()
    {
        return shoppingSourcesCount;
    }

    public void setShoppingSourcesCount (String shoppingSourcesCount)
    {
        this.shoppingSourcesCount = shoppingSourcesCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [recipeSourcesCount = "+recipeSourcesCount+", shoppingSourcesCount = "+shoppingSourcesCount+"]";
    }
}
			
	