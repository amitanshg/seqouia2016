package com.beans.bing1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RootObject
{
  private String _type;

  public String getType() { return this._type; }

  public void setType(String _type) { this._type = _type; }

  private WebPages webPages;

  public WebPages getWebPages() { return this.webPages; }

  public void setWebPages(WebPages webPages) { this.webPages = webPages; }
}
