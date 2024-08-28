import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_722 {

    static String sParam1 = "#1}vRqm}!h";

    static int sParam2 = 527;

    static boolean sParam3 = true;

    static Socket s = new Socket(sParam1, sParam2, sParam3);

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket closeSocket(Socket s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (Exception e) {
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_722().closeSocket(s);
    }
}
