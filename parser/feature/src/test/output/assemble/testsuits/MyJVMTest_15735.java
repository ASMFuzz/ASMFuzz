import java.net.*;
import java.io.*;

public class MyJVMTest_15735 {

    static InputStream in = null;

    static OutputStream out = null;

    static Socket client = null;

    static InputStream tin = null;

    static OutputStream tout = null;

    void purge() throws IOException {
        boolean done = false;
        int i = 0;
        client.setSoTimeout(1000);
        while (!done && i != -1) {
            try {
                i = in.read();
            } catch (IOException e) {
                done = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15735().purge();
    }
}
