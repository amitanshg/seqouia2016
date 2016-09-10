package com.jarvis.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class SampleSearch {
	public static void main(String[] args) throws Exception {
		String temp = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&"
				+ "q=javacodingtutorial.blogspot.com&userip=USERS-IP-ADDRESS";
		for (int i = 0; i < 100; i = i + 4) {
			System.out.println("Time : " + i + "\n");
			URL url = new URL(temp + "&start=" + i);
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Referer", "www.facebook.com");
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			System.out.println(connection.getURL());
			System.out.println();
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			JSONObject json = new JSONObject(builder.toString());
			System.out.println(json);
		}

	}
}
