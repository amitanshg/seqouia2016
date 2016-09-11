package com.jarvis.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.beans.bing1.RootObject;
import com.beans.bing1.Value;
import com.google.gson.Gson;
import com.jarvis.util.APIResponse;
import com.jarvis.util.APIResponseParser;
import com.jarvis.util.BingRequest;
import com.jarvis.util.Constants;
import com.jarvis.util.Entity;
import com.jarvis.util.HttpUtility;
import com.jarvis.util.Mongo;
import com.jarvis.util.RuleEngine;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Servlet implementation class APIRequest
 */
public class APIRequest extends HttpServlet implements Constants {
	private static final long serialVersionUID = 1L;

	public static String requestApi(String q)
			throws UnsupportedEncodingException {
		// test sending GET request
		q = URLEncoder.encode(q, "UTF-8");
		String allines = "";
		String requestURL = Constants.REQUEST_URL + q;
		try {
			HttpUtility.sendGetRequest(requestURL);
			String[] response = HttpUtility.readMultipleLinesRespone();
			for (String line : response) {
				allines += line;
				// System.out.println(line);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		HttpUtility.disconnect();
		return allines;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public APIRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mongo mongo = new Mongo();
		HashMap<String, Object> dbData = new HashMap<String, Object>();

		String q = request.getParameter("q");
		System.out.println("JARVIS HERE " + q);
		String s = requestApi(q);
		APIResponse apiresponse = APIResponseParser.getResponseOnject(s);
		RuleEngine re = new RuleEngine();
		JSONObject result = re.evaluateResults(apiresponse);

		// TODO:parse the apiresponse
		List<Entity> elist = apiresponse.getEntities();
		System.out.println("Before:\n" + elist);

		JSONArray displayUrls = new JSONArray();
		if (result.isNull("serviceType")) {
			// return result.get("defaultMessage");
		} else {

			JSONArray queries = result.getJSONArray("queries");
			for (int i = 0; i < queries.length(); i++) {
				RootObject robject = BingRequest.requestBing(queries
						.getString(i));
				List<Value> list = robject.getWebPages().getValue();
				String displayurl = list.get(0).getDisplayUrl();
				displayUrls.put(displayurl);
			}

		}
		DBObject entityIntentData = new BasicDBObject();
		Object[] obs = result.keySet().toArray();
		for (int i = 0; i < obs.length; i++) {
			System.out.println((String) obs[i] +  " -- " + obs[i].toString());
			dbData.put((String) obs[i], result.get(obs[i].toString()));
		}
		dbData.put("display_urls", displayUrls);

		// TODO:call bing
		mongo.writeDataToDb("jarvis_sequoia", "123", dbData);
		response.getWriter().write(dbData.toString());
		//response.sendRedirect("http://localhost:8080/JARVIS_3.0&result="+dbData.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static Map<String, String> getQueryParameters(String queryString) {
		 Map<String, String> queryParameters = new HashMap<>();
	    String[] parameters = queryString.split("&");

	    for (String parameter : parameters) {
	        String[] keyValuePair = parameter.split("=");
	        //String[] values = queryParameters.get(keyValuePair[0]);
	        queryParameters.put(keyValuePair[0], keyValuePair[1]);
	    }
	    return queryParameters;
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request,response);
		 // Read from request
	    StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    
	
	    String q = buffer.toString();
	    System.out.println("BEFORE PARSING POST: \n" + q);
	    Map<String, String> map = getQueryParameters(q);
	    q = map.get("text");
	    System.out.println(map);
	    //JSONObject jsonObject = new JSONObject(q);
	    //q = jsonObject.getString("text");
	    //q = jsonObject.toString();
	    q = q.replaceAll("\\+", " ");
	    System.out.println("AFTER PARSING POST: \n" + q);
	    
	    Mongo mongo = new Mongo();
		HashMap<String, Object> dbData = new HashMap<String, Object>();

		//String q = request.getParameter("q");
		
		String s = requestApi(q);
		APIResponse apiresponse = APIResponseParser.getResponseOnject(s);
		RuleEngine re = new RuleEngine();
		JSONObject result = re.evaluateResults(apiresponse);
		
		// TODO:parse the apiresponse
		List<Entity> elist = apiresponse.getEntities();
		System.out.println("Before:\n" + elist);
		Collections.sort(elist, new Comparator<Entity>() {
			@Override
			public int compare(Entity a1, Entity a2) {
				return a1.getScore() - a2.getScore() < 0 ? 1 : -1;
			}
		});
		System.out.println("Before:\n" + elist);
		String finalMessage = "";
		JSONArray displayUrls = new JSONArray();
		System.out.println("result:\n" + result);
		if (result.isNull("serviceType")) {
			finalMessage = result.getString("message");
			// return result.get("defaultMessage");
		} else {
			JSONArray queries = result.getJSONArray("queries");
			finalMessage = "I understand you are requesting for a service.\n These are the service results\n";
			for (int i = 0; i < queries.length(); i++) {
				RootObject robject = BingRequest.requestBing(queries
						.getString(i));
				List<Value> list = robject.getWebPages().getValue();
				String displayurl = list.get(0).getDisplayUrl();
				finalMessage += (displayurl + "\n"); 
				displayUrls.put(displayurl);
			}
		}
		
		for (Iterator<Entity> iterator = elist.iterator(); iterator.hasNext();) {
			Entity entity = (Entity) iterator.next();
			finalMessage += (entity.getType() + " - " + entity.getEntity() + "\n");
		}
		DBObject entityIntentData = new BasicDBObject();
		Object[] obs = result.keySet().toArray();
		for (int i = 0; i < obs.length; i++) {
			System.out.println((String) obs[i] +  " -- " + obs[i].toString());
			dbData.put((String) obs[i], result.get(obs[i].toString()));
		}
		dbData.put("display_urls", displayUrls);
		//dbData.put("text", "123");
		
	
		
		
		
		// TODO:call bing
		mongo.writeDataToDb("jarvis_sequoia", "123", dbData);
		dbData.put("text", finalMessage.toString());
		response.setContentType("application/json;charset=UTF-8");
		String json = new Gson().toJson(dbData);
		
		
		System.out.println(dbData.toString());
		response.getWriter().write(json);
		//response.sendRedirect("http://localhost:8080/JARVIS_3.0&result="+dbData.toString());

	}

}
