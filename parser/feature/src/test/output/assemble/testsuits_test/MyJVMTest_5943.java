import java.io.*;
import java.security.*;

public class MyJVMTest_5943 {

    void readConstData(int n) throws IOException {
        if (n <= 0)
            return;
        byte[] buf = new byte[n];
        in.read(buf);
        for (int i = 0; i < n; i++) if (buf[i] != (byte) i)
            throw new IOException("const data was incorrect, " + "n = " + n + ", i = " + i);
    }

    void writeConstData(int n) throws IOException {
        if (n <= 0)
            return;
        byte[] buf = new byte[n];
        for (int i = 0; i < n; i++) buf[i] = (byte) i;
        out.write(buf);
    }

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    static int MAX_BLOCKSIZE = 8 * 2;

    void respondConst() throws IOException {
        for (int i = 1; i <= MAX_BLOCKSIZE; i++) {
            readConstData(i);
            writeConstData(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5943().respondConst();
    }
}
