import java.net.*;
import java.util.*;

public class MyJVMTest_14362 {

    static String s = "6x?fRVR2kv";

    static boolean debug = false;

    static DatagramSocket server = null;

    String print(String s) {
        if (debug)
            System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14362().print(s);
    }
}
