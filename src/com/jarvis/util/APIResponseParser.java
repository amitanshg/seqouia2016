package com.jarvis.util;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class APIResponseParser {
	//static String response = "{ \"query\": \"i am anshul.i need a cab\", \"intents\": [   {\"intent\": \"reqService\",\"score\": 0.9864943 },{\"intent\": \"None\",\"score\": 0.0284212027}], \"entities\": [{\"entity\": \"cab\",\"type\": \"serviceType\", \"startIndex\": 21,\"endIndex\": 23,\"score\": 0.8150572} ]}";
	public static APIResponse  getResponseOnject(String response) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert JSON string to Object
			APIResponse response1 = mapper.readValue(response, APIResponse.class);
			return response1;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}