import java.net.*;
import java.io.*;

public class MyJVMTest_2724 {

    static int port = 0;

    static long delay = 0;

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
        new MyJVMTest_2724().run();
    }
}
