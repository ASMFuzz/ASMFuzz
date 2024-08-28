import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.*;
import java.security.cert.*;

public class MyJVMTest_1281 {

    static SSLSocket clientsideSocket = null;

    static Exception clientException = null;

    static boolean done = false;

    void run() {
        try {
            clientsideSocket.startHandshake();
        } catch (Exception e) {
            e.printStackTrace();
            clientException = e;
        } finally {
            done = true;
            try {
                clientsideSocket.close();
            } catch (IOException e) {
            }
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1281().run();
    }
}
