package Utils;

public class Port {

    private static int port = 0;

    private static int getRandom() {
//        String random = "";
//        random +=
        int random = (int)Math.floor(Math.random() * (10000 - 1000) + 1000);
//        System.out.println(random);
        return random;
    }

    public static int getPort() {
        return (port == 0)?getRandom():port;
    }
}
