package Utils;
import Object.Hardware;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class DBQueries {

    private static FindIterable<Document> hardwares;
    private static ArrayList<Hardware> hardwaresArray = new ArrayList<Hardware>();
    private static Hardware hardware;
    private static Document document;


    //To insert an object into the database
    public static String insert(Hardware hardware) {
        document = new Document()
                .append("id", findNewId()+1)
                .append("name", hardware.getName())
                .append("price", hardware.getPrice())
                .append("category", hardware.getCategory())
                .append("manufacturer", hardware.getManufacturer())
                .append("description", hardware.getDescription())
                .append("quantity", hardware.getQuantity());
        MongoDB.hardwares.insertOne(document);
        return "Document successfully added";
//        System.out.println("document successfully inserted! ");
//        return false;
    }

    //to fetch all the data from the database
    public static ArrayList<Hardware> fetchAll(){
        hardwares = MongoDB.hardwares.find();
        populateArray();
        return hardwaresArray;
    }

    //to search a specific object with name
    public static Hardware search(String name) {
        hardware = new Hardware();
        BasicDBObject key = new BasicDBObject("name", name);
        document = MongoDB.hardwares.find(key).first();
        if(document!=null)
            createHardware(document);
        return hardware;
    }

    //to find the id of last added item and incrementing it to add a unique id to the new object
    private static double findNewId(){
        fetchAll();
        if(!hardwaresArray.isEmpty())
            return hardwaresArray.get(hardwaresArray.size()-1).getId();
        return 0;
    }


    //populate the array list with the objects of hardware
    private static void populateArray() {
        hardwaresArray.clear();
        try{
            for(Document document: hardwares){
                createHardware(document);
                hardwaresArray.add(hardware);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //initialize the hardware object
    private static void createHardware(Document document) {
        hardware = new Hardware(
                document.getString("name"),
                document.getString("category"),
                document.getString("manufacturer"),
                document.getString("description"),
                document.getDouble("price"),
                document.getDouble("quantity")
        );
        hardware.setId(document.getDouble("id"));
    }

}
