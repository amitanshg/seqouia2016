package com.jarvis.util;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.mongodb.MongoClient;
import java.util.HashMap; 
import org.json.*;
import java.util.*;

class Mongo {
    static MongoClient conn = null;

    public Mongo() {
        if(conn == null) {
            conn = new MongoClient("localhost", 27017);
        }
    }

    public  void writeDataToDb(String dbName, String user_id, HashMap<String, Object> jsonData) {
        DB db = this.conn.getDB(dbName);
        DBCollection coll = db.getCollection("user_activity");
        DBObject data = new BasicDBObject();
        data.put("user_id", user_id);
        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            data.put(entry.getKey(), entry.getValue());
        }
        coll.insert(data);
    }
    
   public JSONObject getDataFromDb(String dbName, String user_id) {
	   DB db = this.conn.getDB(dbName);
	   return new JSONObject();
	   
   }
}