import java.io.*;
import java.security.*;

public class MyJVMTest_5069 {

    static int n = 367794143;

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    int readConstData(int n) throws IOException {
        if (n <= 0)
            return;
        byte[] buf = new byte[n];
        in.read(buf);
        for (int i = 0; i < n; i++) if (buf[i] != (byte) i)
            throw new IOException("const data was incorrect, " + "n = " + n + ", i = " + i);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5069().readConstData(n);
    }
}
