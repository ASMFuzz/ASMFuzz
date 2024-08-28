import java.net.*;
import java.io.*;

public class MyJVMTest_10120 {

    static Socket s = null;

    static int port = 9;

    static long delay = 0;

    void run() {
        System.out.println("Closer starts");
        try {
            s.close();
        } catch (IOException ioe) {
        }
        System.out.println("Closer ends");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10120().run();
    }
}
