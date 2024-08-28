import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_9900 {

    static InetAddress sParam1 = null;

    static int sParam2 = 565;

    static InetAddress sParam3 = null;

    static int sParam4 = 307;

    static Socket s = new Socket(sParam1, sParam2, sParam3, sParam4);

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
        new MyJVMTest_9900().closeSocket(s);
    }
}
