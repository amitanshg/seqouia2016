package com.jarvis.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.beans.bing1.RootObject;
import com.beans.bing1.Value;
import com.jarvis.util.APIResponse;
import com.jarvis.util.APIResponseParser;
import com.jarvis.util.BingRequest;
import com.jarvis.util.Constants;
import com.jarvis.util.Entity;
import com.jarvis.util.HttpUtility;
import com.jarvis.util.Intent;
import com.jarvis.util.Mongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Servlet implementation class APIRequest
 */
public class APIRequest extends HttpServlet implements Constants  {
	private static final long serialVersionUID = 1L;
	public static String requestApi(String q) throws UnsupportedEncodingException {
		// test sending GET request
		q = URLEncoder.encode(q, "UTF-8");
		String allines = "";
		String requestURL = Constants.REQUEST_URL + q;
		try {
			HttpUtility.sendGetRequest(requestURL);
			String[] response = HttpUtility.readMultipleLinesRespone();
			for (String line : response) {
				allines += line;
				//System.out.println(line);
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mongo mongo = new Mongo();
		HashMap<String, Object> dbData = new HashMap<String, Object>();
	
		String q = request.getParameter("uname");
		System.out.println("JARVIS HERE " + q);
		String s = requestApi(q);
		APIResponse apiresponse = APIResponseParser.getResponseOnject(s);
		//TODO:parse the apiresponse
		List<Entity> elist = apiresponse.getEntities();
		System.out.println("Before:\n" + elist);
	    Collections.sort(elist, new Comparator<Entity> () {
	    	@Override
	    	public int compare(Entity a1, Entity a2) {
	    		return a1.getScore()-a2.getScore()<0?1:-1;
	    	}
	    });
		List<Intent> ilist = apiresponse.getIntents();
		System.out.println("After:\n" + elist);
		System.out.println(ilist);
		String finalEntities = "";
		JSONArray entityArray = new JSONArray();
		
		for (Iterator<Entity> iterator = elist.iterator(); iterator.hasNext();) {
			Entity entity = (Entity) iterator.next();
			finalEntities += entity.getEntity() + " ";
			entityArray.put(entity.getEntity());
		}
		
		JSONArray intentArray = new JSONArray();
		String topIntent = ilist.get(0).getIntent();
		/*for (Iterator<Intent> iterator = ilist.iterator(); iterator.hasNext();) {
			Intent intent = (Intent) iterator.next();
			intentArray.put(intent.getIntent());
		}*/
		DBObject entityIntentData = new BasicDBObject();
		entityIntentData.put("intent", topIntent);
		entityIntentData.put("entity", entityArray);

		//TODO:call bing
		RootObject robject = BingRequest.requestBing(finalEntities);
		List<Value> list = robject.getWebPages().getValue();
		int i=0;
		String displayurl = list.get(0).getDisplayUrl();
		dbData.put("final_query", finalEntities);
		dbData.put("intentEntities", entityIntentData);
		dbData.put("display_url", displayurl);
		mongo.writeDataToDb("user_data", "123", dbData);
		response.getWriter().write(s);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
