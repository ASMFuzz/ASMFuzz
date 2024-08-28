import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_13497 {

    static String sParam1 = "fXkpMK^HFn";

    static int sParam2 = 158;

    static boolean sParam3 = true;

    static Socket s = new Socket(sParam1, sParam2, sParam3);

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
        new MyJVMTest_13497().testSocket(s);
    }
}
