package com.jarvis.util;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JavaSample {
	static String key = "96da00acc0264546bd78c7ccd58e462f";
	
	public static void main(String[] args) {
		CloseableHttpClient  httpclient = HttpClients.createDefault();
		try {
			URIBuilder builder = new URIBuilder("https://api.cognitive.microsoft.com/bing/v5.0/search/");

			builder.setParameter("q", "bengal");
			builder.setParameter("count", "10");
			builder.setParameter("offset", "0");
			builder.setParameter("mkt", "en-us");	
			builder.setParameter("safesearch", "Strict");
			
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			request.setHeader("Ocp-Apim-Subscription-Key", key);


			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String res = EntityUtils.toString(entity);
				System.out.println("JSON is: " + res);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
