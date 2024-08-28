import java.net.*;
import java.io.*;

public class MyJVMTest_7856 {

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
        new MyJVMTest_7856().run();
    }
}
