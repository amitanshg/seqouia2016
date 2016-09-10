package com.beans.bing1;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebPages
{
  private String webSearchUrl;

  public String getWebSearchUrl() { return this.webSearchUrl; }

  public void setWebSearchUrl(String webSearchUrl) { this.webSearchUrl = webSearchUrl; }

  private int totalEstimatedMatches;

  public int getTotalEstimatedMatches() { return this.totalEstimatedMatches; }

  public void setTotalEstimatedMatches(int totalEstimatedMatches) { this.totalEstimatedMatches = totalEstimatedMatches; }

  private ArrayList<Value> value;

  public ArrayList<Value> getValue() { return this.value; }

  public void setValue(ArrayList<Value> value) { this.value = value; }
}
