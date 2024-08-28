import java.net.*;
import java.io.*;

public class MyJVMTest_9517 {

    static int DEFAULT_PORT = 1080;

    static int port = 6;

    static ServerSocket server = null;

    static boolean useV4 = false;

    static boolean done = false;

    static InputStream in = null;

    static OutputStream out = null;

    static Socket client = null;

    static InputStream tin = null;

    static OutputStream tout = null;

    void terminate() {
        done = true;
        try {
            server.close();
        } catch (IOException unused) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9517().terminate();
    }
}
