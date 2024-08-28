import java.io.*;
import java.net.*;
import java.util.jar.*;

public class MyJVMTest_2442 {

    static BufferedReader reader = null;

    static PrintStream out = null;

    static boolean hasReadData = false;

    void run() {
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                hasReadData = true;
                out.println(str);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2442().run();
    }
}
