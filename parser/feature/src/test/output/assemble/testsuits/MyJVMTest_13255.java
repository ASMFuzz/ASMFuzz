import java.net.*;
import java.io.*;

public class MyJVMTest_13255 {

    static Socket s = null;

    void run() {
        System.out.println("Closer starts");
        try {
            s.close();
        } catch (IOException ioe) {
        }
        System.out.println("Closer ends");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13255().run();
    }
}
