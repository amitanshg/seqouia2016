package com.jarvis.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Mongo {
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
    
   public ArrayList getDataFromDb(String dbName, String user_id) {
	   DB db = this.conn.getDB(dbName);
	   DBCollection coll = db.getCollection("user_activity");
	   BasicDBObject query = new BasicDBObject();
	   query.put("user_id", user_id);
	   DBCursor cursor = coll.find(query);
	   ArrayList<Object> userData = new ArrayList<Object>();
	   while (cursor.hasNext()) {
		   Object doc = cursor.next();
		   userData.add(doc);
	       System.out.println(doc);
	   }
	   return userData;
   }
   
   public void removeDataFromDb(String dbName, String user_id) {
	   DB db = this.conn.getDB(dbName);
	   DBCollection coll = db.getCollection("user_activity");
	   BasicDBObject query = new BasicDBObject();
	   query.put("user_id", user_id);
	   DBCursor cursor = coll.find(query);
	   ArrayList<Object> userData = new ArrayList<Object>();
	   while (cursor.hasNext()) {
		   DBObject doc = cursor.next();
		  System.out.println(doc);
		  coll.remove(doc);
	   }
   }
   
   public static void main(String[] args) throws Exception {

	    Mongo mongo = new Mongo();
	    String userId = "123";
	    String dbName = "user_data";
	    HashMap<String, Object> userData = new HashMap<String, Object>();
	    userData.put("a", "1");
	    userData.put("b", "2");
	    userData.put("c", "3");
	    mongo.writeDataToDb(dbName, userId, userData);

	}
}