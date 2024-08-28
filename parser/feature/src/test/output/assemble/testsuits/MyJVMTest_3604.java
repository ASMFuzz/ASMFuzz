import java.io.*;
import java.net.*;

public class MyJVMTest_3604 {

    static Socket s = null;

    void run() {
        try {
            Thread.sleep(5000);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3604().run();
    }
}
