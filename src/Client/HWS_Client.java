package Client;
import Utils.ByteConverter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;
import Object.Hardware;


public class HWS_Client {

    private static DatagramSocket clientSocket;
    private static InetAddress IP;
    private static byte[] sendData;
    private static byte[] recieveData;
    private static DatagramPacket packet;
    private static Scanner input;
    private static Hardware hardware;
//    private static String string;
    private static int choice;
    private static boolean cont;

    public static void main(String[] args) throws IOException {
        init();
        while(cont){
            sendData = new byte[9999];
            recieveData = new byte[9999];
            displayMenu();
            userInput();
            hardware.reset();
        }
    }

    private static void init() {
        try{
            IP = InetAddress.getByName("Deadbeat");
            clientSocket = new DatagramSocket();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            cont = true;
            input = new Scanner(System.in);
            hardware = new Hardware();
        }
    }

    private static void displayMenu() {
        System.out.println("\n1-- Enter {1} to insert a Hardware\n2-- Enter {2} to view all\n3-- Enter {3} to search a specific hardware\n4-- Enter {4} to exit");
    }

    private static boolean userInput() {
        System.out.print("Enter your choice: ");
        choice = input.nextInt();
        System.out.println("User choice = " + choice);
        try {
            if (choice == 1) {
                hardware = createHardware();
                sendData = ByteConverter.serialize(hardware);
            } else if (choice == 2) {
                sendData = ByteConverter.serialize("view entire record");
            } else if (choice == 3) {
                input = new Scanner(System.in);
                System.out.print("Enter hardware name: ");
                String search = input.nextLine();
                sendData = ByteConverter.serialize(search);
            } else {
                System.out.println("Exiting");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            displayRes(sendReq());
        }
        return true;
    }

    private static void displayRes(Object object) {
        if(object instanceof Hardware) {
            Hardware hardware = (Hardware) object;
            if(!hardware.getName().equalsIgnoreCase(""))
                hardware.displayHardwareInfo();
            else {
                System.out.println("Bad Request 404 :( No result found");
            }
        }
        else if (object instanceof ArrayList){
            ArrayList<Hardware> hardwares = (ArrayList<Hardware>) object;
            if(!hardwares.isEmpty()) {
                for (Hardware hardware : hardwares) {
                    hardware.displayHardwareInfo();
                }
            }else {
                System.out.println("Bad Request 404 :( No result found");
            }
        }
        else {
            String response = (String) object;
            System.out.println(response);
        }
    }

    private static Hardware createHardware() {
        input = new Scanner(System.in);
        Object[] attr = new Object[6];
        String[] statements = {
                "Name",
                "Category",
                "Manufacturer",
                "Description",
                "Price",
                "Quantity"
        };
        for(int i = 0; i < attr.length; i++) {
            System.out.print("Enter " + statements[i] + ": ");
            attr[i] = (i < 4) ? input.nextLine():input.nextDouble();
        }
        Hardware hardware = new Hardware(
                (String) attr[0],
                (String) attr[1],
                (String) attr[2],
                (String) attr[3],
                (Double) attr[4],
                (Double) attr[5]
        );
        return hardware;
    }

    private static Object sendReq() {
        try {
            packet = new DatagramPacket(sendData, sendData.length, IP, 6969);
//            sendData = new byte[9999];
            clientSocket.send(packet);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return recieveRes();
    }

    private static Object recieveRes() {
        try {
            packet = new DatagramPacket(recieveData, recieveData.length);
            clientSocket.receive(packet);
            return ByteConverter.deserialize(packet.getData());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
