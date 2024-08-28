import java.net.*;
import java.util.*;

public class MyJVMTest_4956 {

    static String s = "~2F\\ABF&3g";

    static boolean debug = false;

    static DatagramSocket server = null;

    String print(String s) {
        if (debug)
            System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4956().print(s);
    }
}
