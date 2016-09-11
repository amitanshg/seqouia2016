package com.jarvis.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/* 
 Greeting: Hello, Greetings. How can I help you today?
 Feedback: Should I take it as a feedback?
 Affirmative: Okay, I'm processing your request.
 Negative: I need clear instructions for what to do.
 None: What do you intend?
 */

public class RuleEngine {
	public static final String[] excludeEntities = new String[] { "clientName",
			"forWhoom", "phoneNumber" };
	public static final String defaultMessage = "Hi, I am JARVIS, I'm afraid. I don't understand, sorry!";
	public static final String AffirmativeMessage = "Okay, I'm processing your request.";
	public static final String NegativeMessage = "I need clear instructions for what to do";
	public static final String NoneMessage = "What do you intend?";
	public static final String GreetingMessage = "Greetings!! How can I help ?";
	public static final String InformationMessage = "Stored.";
	public static final String FeedBackMessage = "Should i take it as a feedback?";

	public JSONObject evaluateResults(APIResponse apiresponse) {

		JSONObject response = new JSONObject();

		List<Entity> elist = apiresponse.getEntities();
		System.out.println("Before:\n" + elist);
		Collections.sort(elist, new Comparator<Entity>() {
			@Override
			public int compare(Entity a1, Entity a2) {
				return a1.getScore() - a2.getScore() < 0 ? 1 : -1;
			}
		});
		List<Intent> ilist = apiresponse.getIntents();
		System.out.println("After:\n" + elist);

		String topIntent = ilist.get(0).getIntent();

		response.put("intent", ilist.get(0).getIntent());
		if (ilist.get(0).getScore() > 0.4
				&& ilist.get(0).getIntent().equals("reqService")) {
			response.put("serviceType", true);
		} else if (ilist.get(0).getIntent().equals("information")) {
			response.put("message", InformationMessage);
		} else if (ilist.get(0).getIntent().equals("negative")) {
			response.put("message", NegativeMessage);
		} else if (ilist.get(0).getIntent().equals("greeting")) {
			response.put("message", GreetingMessage);
		} else if (ilist.get(0).getIntent().equals("None")) {
			response.put("message", NoneMessage);
		} else if (ilist.get(0).getIntent().equals("affirmative")) {
			response.put("message", AffirmativeMessage);
		} else if (ilist.get(0).getIntent().equals("feedback")) {
			response.put("message", FeedBackMessage);
		} else {
			response.put("message", defaultMessage);
		}
		// System.out.println("RESPONSE MESSAGE  "+response.get("message"));
		// response.put("message", defaultMessage);
		JSONArray queries = new JSONArray();
		String query = "";
		JSONArray entityArray = new JSONArray();
		Integer serviceTypeFound = 0;
		System.out.println("### Before " + query + " ###");
		for (Iterator<Entity> iterator = elist.iterator(); iterator.hasNext();) {
			System.out.println("###" + query + "###");
			Entity entity = (Entity) iterator.next();
			if (Arrays.asList(excludeEntities).contains(entity.getType())) {
				continue;
			}
			if (entity.getType().equals("serviceType")) {

				serviceTypeFound++;
			}
			if (entity.getType().equals("serviceType") && serviceTypeFound >= 2) {
				queries.put(query);
				query = "";
				serviceTypeFound = 1;
			}
			query += entity.getEntity() + " ";
			entityArray.put(entity.getEntity());

		}
		if (!query.equals("")) {
			queries.put(query);
		}
		response.put("entities", entityArray);
		response.put("queries", queries);
		return response;
	}
}
