import java.net.*;
import java.io.*;

public class MyJVMTest_3963 {

    static Socket s = null;

    static int port = 1;

    static long delay = -9223372036854775808L;

    static boolean connected = false;

    void run() {
        System.out.println("Other starts: sleep " + delay);
        try {
            Thread.sleep(delay);
            System.out.println("Other opening socket");
            Socket s = new Socket("localhost", port);
            synchronized (this) {
                connected = true;
            }
            s.close();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Other ends");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3963().run();
    }
}
