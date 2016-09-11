package com.jarvis.util;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.beans.bing1.RootObject;
import com.beans.bing1.Value;
public class BingRequest {
	static String key = "96da00acc0264546bd78c7ccd58e462f";
	
	public static RootObject requestBing(String q) {
		CloseableHttpClient  httpclient = HttpClients.createDefault();
		Mongo mongo = new Mongo();
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			URIBuilder builder = new URIBuilder("https://api.cognitive.microsoft.com/bing/v5.0/search/");
			builder.setParameter("q", q);
			builder.setParameter("count", "1");
			builder.setParameter("offset", "0");
			builder.setParameter("mkt", "en-IN");	
			builder.setParameter("safesearch", "Strict");
		
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			request.setHeader("Ocp-Apim-Subscription-Key", key);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String res = EntityUtils.toString(entity);
				RootObject response1 = mapper.readValue(res, RootObject.class);
				List<Value> list = response1.getWebPages().getValue();
				int i=0;
				String displayurl = list.get(0).getDisplayUrl();
			
				return response1;
				/*for (Iterator<Value> iterator = list.iterator(); iterator.hasNext();) {
					Value value = (Value) iterator.next();
					i++;
					System.out.println(i+ "  " + value.getDisplayUrl());
					break;
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
	public static void main(String[] args) {
		requestBing("bengal");
	}
}
