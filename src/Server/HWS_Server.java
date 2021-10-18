package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import Object.Hardware;
import Utils.ByteConverter;
import Utils.DBQueries;
import Utils.MongoDB;
import Utils.Port;


public class HWS_Server{

    private static DatagramSocket serverSocket;
    private static byte[] receivedData;
    private static DatagramPacket packet;
    private static InetAddress clientIP;
    private static int clientPort;
    private static byte[] sendData;


    public static void main(String[] args){

        try{
            init();
            while(true) {
                System.out.println("Server is running");
                receivedData = new byte[9999];
                sendRes(recieveReq());
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void init() throws SocketException {
        MongoDB.connectMongo();
        try{
            serverSocket = new DatagramSocket(6969);
        }catch (Exception e) { System.out.println(e.getMessage()); }
    }

    private static Object recieveReq() {
        try {
            packet = new DatagramPacket(receivedData, receivedData.length);
            serverSocket.receive(packet);
//            System.out.println("request ");
            clientIP = packet.getAddress();
            clientPort = packet.getPort();
            return ByteConverter.deserialize(packet.getData());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void sendRes(Object object) {
        try {
            if (object instanceof Hardware) {
                sendData = ByteConverter.serialize(DBQueries.insert((Hardware) object));
            }else {
                String string = (String) object;
                sendData = (string.equalsIgnoreCase("view entire record"))
                        ?
                        ByteConverter.serialize(DBQueries.fetchAll())
                        :
                        ByteConverter.serialize(DBQueries.search(string));
            }
            packet = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
            serverSocket.send(packet);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
