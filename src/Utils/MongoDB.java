package Utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDB {

    private static MongoClientURI mongoClientURI =
            new MongoClientURI("mongodb+srv://system:1234@cluster0.8be3g.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

    private static MongoClient mongoClient;

    public static MongoDatabase mongoDatabase;

    public static MongoCollection<Document> hardwares;

    public static void connectMongo(){
        try{
            Logger mongoLogger=Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            System.setProperty("jdk.tls.trustNameService","true");
            mongoClient = new MongoClient(mongoClientURI);
            mongoDatabase = mongoClient.getDatabase("BakaBaka");
            hardwares = mongoDatabase.getCollection("Hardwares");
//            comments = mongoDatabase.getCollection("comments");
        }catch (Exception exception) {
            System.out.println("not any error XD");
        }
    }



}
