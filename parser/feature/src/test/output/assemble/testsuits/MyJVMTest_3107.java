import java.net.*;
import java.io.*;

public class MyJVMTest_3107 {

    static Socket s = null;

    void run() {
        System.out.println("Sender starts");
        try {
            s.getOutputStream().write(new byte[128 * 1024]);
        } catch (IOException ioe) {
        }
        System.out.println("Sender ends");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3107().run();
    }
}
