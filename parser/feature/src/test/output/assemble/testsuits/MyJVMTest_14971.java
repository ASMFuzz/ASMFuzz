import java.nio.channels.*;
import java.net.*;
import java.io.*;

public class MyJVMTest_14971 {

    static InputStream in = null;

    void run() {
        try {
            byte[] b = new byte[100];
            for (; ; ) {
                int n = in.read(b);
                if (n < 0)
                    return;
                System.out.write(b, 0, n);
            }
        } catch (IOException ioe) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14971().run();
    }
}
