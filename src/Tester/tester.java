package Tester;

import Utils.DBQueries;
import Utils.MongoDB;
import Object.Hardware;
import Utils.Port;

import java.util.ArrayList;

public class tester {

    public static void main(String[] args) {
        MongoDB.connectMongo();
//        DBQueries.searchHardware("RTX");
//        DBQueries.findNewId();
//        displayRes(DBQueries.insert(new Hardware("K2", "Mouse", "Laptop", "Dell", 2929, 20.0)));;
//        System.out.println(Port.getPort());
//        DBQueries.fetchAll();
        displayRes((Object) DBQueries.fetchAll());

    }

    private static void displayRes(Object object) {
        if(object instanceof Hardware) {
            Hardware hardware = (Hardware) object;
            hardware.displayHardwareInfo();
        }
        else if (object instanceof ArrayList){
            ArrayList<Hardware> hardwares = (ArrayList<Hardware>) object;
            for (Hardware hardware : hardwares) {
                hardware.displayHardwareInfo();
            }
        }
        else {
            String response = (String) object;
            System.out.println(response);
        }
    }

    private static void displayHardware(Hardware hardware) {
        System.out.printf("\nID: %f\nNAME: %s\nPRICE: %f\nCATEGORY: %s\nMANUFACTURER: %s\nDESCRIPTION: %s\nQUANTITY: %f",
                hardware.getId(),
                hardware.getName(),
                hardware.getPrice(),
                hardware.getCategory(),
                hardware.getManufacturer(),
                hardware.getDescription(),
                hardware.getQuantity());
    }
}
