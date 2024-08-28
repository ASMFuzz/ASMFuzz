import java.io.*;
import java.security.*;

public class MyJVMTest_4379 {

    static int n = 2087398971;

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    int writeConstData(int n) throws IOException {
        if (n <= 0)
            return;
        byte[] buf = new byte[n];
        for (int i = 0; i < n; i++) buf[i] = (byte) i;
        out.write(buf);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4379().writeConstData(n);
    }
}
