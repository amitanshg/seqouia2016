package com.jarvis.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CustomGoogleSearch {
	final static String apiKey = "AIzaSyDBHj2fj7OTy4JM8WtaosPVO1GYlAX1Pf0";
	final static String customSearchEngineKey = "014130208108474947322:vpddm6e5yp8";
	final static String searchURL = "https://www.googleapis.com/customsearch/v1?";

	public static String search(String pUrl) {
		try {
			URL url = new URL(pUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static String buildSearchString(String searchString, int start, int numOfResults) {
		String toSearch = searchURL + "key=" + apiKey + "&cx=" + customSearchEngineKey + "&q=";

		// replace spaces in the search query with +
		String newSearchString = searchString.replace(" ", "%20");

		toSearch += newSearchString;

		// specify response format as json
		toSearch += "&alt=json";

		// specify starting result number
		toSearch += "&start=" + start;

		// specify the number of results you need from the starting position
		toSearch += "&num=" + numOfResults;

		System.out.println("Seacrh URL: " + toSearch);
		return toSearch;
	}


	public static void main(String[] args) throws Exception {

		String url = buildSearchString("Chairs", 1, 10);
		String result = search(url);
		System.out.println(result);

	}
}