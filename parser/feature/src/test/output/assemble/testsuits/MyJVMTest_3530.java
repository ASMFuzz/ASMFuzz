import java.io.*;
import java.security.*;
import java.net.*;
import javax.net.*;
import javax.net.ssl.*;

public class MyJVMTest_3530 {

    static String host = ".RM9/EC;~X";

    static ServerSocket ss = null;

    static boolean isHostIPAddr = false;

    static int serverPort = 0;

    void run() {
        try {
            System.out.println("SERVER: waiting for requests...");
            Socket socket = ss.accept();
            System.out.println("SERVER: got a request!");
            host = ((javax.net.ssl.SSLSocket) socket).getSession().getPeerHost();
            System.out.println("SERVER: Host IP address (not the name): " + host);
        } catch (Exception e) {
            System.err.println("Unexpected exceptions: " + e);
            e.printStackTrace();
        }
        if (host != null && (host.charAt(0) > '9') || (host.charAt(0) < '0')) {
            System.out.println("Error: bug 4302026 may not be fixed.");
        } else {
            isHostIPAddr = true;
            System.out.println("Passed!");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3530().run();
    }
}
