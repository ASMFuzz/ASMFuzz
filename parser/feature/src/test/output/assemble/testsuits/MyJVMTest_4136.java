import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_4136 {

    static String sParam1 = "[f<l_}/L}j";

    static int sParam2 = 302;

    static InetAddress sParam3 = null;

    static int sParam4 = 790;

    static Socket s = new Socket(sParam1, sParam2, sParam3, sParam4);

    static int IPTOS_RELIABILITY = 0x4;

    static int failures = 0;

    Socket testSocket(Socket s) {
        try {
            s.setTrafficClass(IPTOS_RELIABILITY);
            int tc = s.getTrafficClass();
        } catch (Exception e) {
            failures++;
            System.err.println("testSocket failed: " + e);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4136().testSocket(s);
    }
}
