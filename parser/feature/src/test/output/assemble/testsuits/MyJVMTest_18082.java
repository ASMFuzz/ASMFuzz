import java.net.*;
import java.io.*;

public class MyJVMTest_18082 {

    static int DEFAULT_PORT = 1080;

    static int port = 0;

    static ServerSocket server = null;

    static boolean useV4 = false;

    static InputStream in = null;

    static OutputStream out = null;

    static Socket client = null;

    static InputStream tin = null;

    static OutputStream tout = null;

    void run() {
        int b;
        while (true) {
            try {
                b = tin.read();
                if (b == -1) {
                    tin.close();
                    tout.close();
                    return;
                }
                tout.write(b);
                tout.flush();
            } catch (IOException e) {
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18082().run();
    }
}
