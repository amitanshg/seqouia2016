package com.beans.bing1;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Value
{
  private String id;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  private String name;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  private String url;

  public String getUrl() { return this.url; }

  public void setUrl(String url) { this.url = url; }

  private String displayUrl;

  public String getDisplayUrl() { return this.displayUrl; }

  public void setDisplayUrl(String displayUrl) { this.displayUrl = displayUrl; }

  private String snippet;

  public String getSnippet() { return this.snippet; }

  public void setSnippet(String snippet) { this.snippet = snippet; }
}
