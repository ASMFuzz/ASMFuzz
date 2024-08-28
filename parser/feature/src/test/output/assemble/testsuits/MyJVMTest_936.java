import java.net.*;
import java.io.*;

public class MyJVMTest_936 {

    static Socket s = null;

    static int port = 9;

    static long delay = 3020299802414106406L;

    void run() {
        System.out.println("Closer starts");
        try {
            s.close();
        } catch (IOException ioe) {
        }
        System.out.println("Closer ends");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_936().run();
    }
}
