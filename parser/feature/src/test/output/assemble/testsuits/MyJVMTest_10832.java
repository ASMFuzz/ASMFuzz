import java.net.*;
import java.io.*;

public class MyJVMTest_10832 {

    static Socket client = null;

    void run() {
        try {
            client.setSoLinger(true, 0);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10832().run();
    }
}
