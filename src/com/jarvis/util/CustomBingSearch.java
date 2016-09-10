package com.jarvis.util;

import java.net.URI;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
//Key - 96da00acc0264546bd78c7ccd58e462f
//Test Bing URL - https://api.cognitive.microsoft.com/bing/v5.0/search?q=bill gates&count=10&offset=0&mkt=en-us&safesearch=Strict
public class CustomBingSearch 
{
	static String key = "96da00acc0264546bd78c7ccd58e462f";
	static String uri = "https://api.cognitive.microsoft.com/bing/v5.0/search?q=bill gates&count=10&offset=0&mkt=en-us&safesearch=Strict";
	
    public static void main(String[] args) 
    {
    	HttpClient httpclient =    new DefaultHttpClient();
        try
        {
            URIBuilder builder = new URIBuilder(uri);
            //builder.setParameter("Category", "{string}");
            URI uri = builder.build();
            
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", key);
            
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}