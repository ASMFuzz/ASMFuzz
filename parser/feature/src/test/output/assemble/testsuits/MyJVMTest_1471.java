import java.net.*;
import java.io.*;

public class MyJVMTest_1471 {

    static Socket s = null;

    static int port = 2;

    static long delay = -9223372036854775808L;

    void run() {
        System.out.println("Sender starts");
        try {
            s.getOutputStream().write(new byte[128 * 1024]);
        } catch (IOException ioe) {
        }
        System.out.println("Sender ends");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1471().run();
    }
}
