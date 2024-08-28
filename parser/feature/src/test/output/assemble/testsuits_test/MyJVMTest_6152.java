import java.net.*;
import java.io.*;

public class MyJVMTest_6152 {

    static InetAddress addr = null;

    static int port = 0;

    void run() {
        try {
            Socket s = new Socket(addr, port);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6152().run();
    }
}
