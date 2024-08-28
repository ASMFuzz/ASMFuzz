import java.io.*;
import java.net.*;

public class MyJVMTest_12939 {

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
        new MyJVMTest_12939().run();
    }
}
