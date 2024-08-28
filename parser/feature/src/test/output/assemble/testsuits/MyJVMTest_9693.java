import java.io.*;
import java.security.*;

public class MyJVMTest_9693 {

    int nextRecordSize() {
        double d = prng.nextGaussian();
        int n;
        if ((prng.nextInt() % 3) == 0) {
            n = (int) (d * 2048);
            n += 15 * 1024;
        } else {
            n = (int) (d * 4096);
            n += 1024;
        }
        if (n < 0)
            return nextRecordSize();
        else if (n > MAX_RECORDSIZE)
            return MAX_RECORDSIZE;
        else
            return n;
    }

    void writeInt(int n) throws IOException {
        int b0, b1, b2, b3;
        b3 = n & 0x0ff;
        n >>= 8;
        b2 = n & 0x0ff;
        n >>= 8;
        b1 = n & 0x0ff;
        n >>= 8;
        b0 = n & 0x0ff;
        out.write(b0);
        out.write(b1);
        out.write(b2);
        out.write(b3);
    }

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    static int MAX_RECORDSIZE = 16384 * 2;

    void writeRandomData() throws IOException {
        int n = nextRecordSize();
        byte[] buf = new byte[n];
        prng.nextBytes(buf);
        writeInt(n);
        out.write(buf);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9693().writeRandomData();
    }
}
