package Tester;

//import Utils.Random;

import java.io.*;
import java.util.Scanner;
import Object.Hardware;
import Utils.Port;

public class tester2 {
    public static void main(String[] args) {
//        String s = "Hello world!";
//        String i = "Bye world!";

//        try {
//            // create a new file with an ObjectOutputStream
////            FileOutputStream out = new FileOutputStream("test.txt");
//            ByteArrayOutputStream bout = new ByteArrayOutputStream(6400);
//            ObjectOutputStream oout = new ObjectOutputStream(bout);
//
//            // write something in the file
//            oout.writeObject(s);
//            bout.reset();
//            oout.writeObject(i);
//
//            System.out.println(bout.toString());
//            // close the stream
//            oout.close();
//
////            // create an ObjectInputStream for the file we created before
////            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
////
////            // read and print what we wrote before
////            System.out.println("" + (String) ois.readObject());
////            System.out.println("" + ois.readObject());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

//        System.out.println(Random.getRandom());
//        Scanner input = new Scanner(System.in);
//        String name = input.nextLine();
//        input.reset();
//        System.out.println(name);
//        double price = input.nextDouble();
//        input.reset();
//        System.out.println(price);
//        String category = input.nextLine();
//        input.reset();
//        System.out.println(category);
//        String manufacturer = input.nextLine();
//        input.reset();
//        System.out.println(manufacturer);
//        String description = input.nextLine();
//        input.reset();
//        System.out.println(description);
//        Object[] attr = new Object[6];
//        String[] statements = {
//                "Name",
//                "Category",
//                "Manufacturer",
//                "Description",
//                "Price",
//                "Quantity"
//        };
//        for(int i = 0; i < attr.length; i++) {
//            System.out.print("Enter " + statements[i] + ": ");
//            if(i < 4){
//                attr[i] = input.nextLine();
//            }else {
//                attr[i] = input.nextDouble();
//            }
//            System.out.println();
//        }
//        Hardware hardware = new Hardware(
//                (String) attr[0],
//                (String) attr[1],
//                (String) attr[2],
//                (String) attr[3],
//                (Double) attr[4],
//                (Double) attr[5]
//        );
//        System.out.println(hardware.getName() + hardware.getQuantity());
//        double quantity = input.nextDouble();
//        input.reset();
//        System.out.println(quantity);

        System.out.println(Port.getPort());
    }
}