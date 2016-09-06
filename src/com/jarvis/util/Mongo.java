import com.mongodb.*;
import com.mongodb.util.JSON;
import com.mongodb.MongoClient;
import java.util.HashMap; 

class Mongo {
    static MongoClient conn = null;

    public static MongoClient getConnection() {
        if(conn == null) {
            conn = new MongoClient("localhost", "27017");
        }
        return conn;
    }

    public static void writeDataToDb(String dbName, String user_id, JSONObject jsonData) {
        DB db = this.getConnection().getDB(dbName);
        DBCollection coll = db.getCollection("user_activity");
        DBObject data = new BasicDBObject();
        data.put("user_id", user_id);
        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            data.put(entry.getKey(), entry.getValue());
        }
        coll.insert(data);
    }
}