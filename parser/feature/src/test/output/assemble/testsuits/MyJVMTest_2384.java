import java.io.*;
import java.security.*;

public class MyJVMTest_2384 {

    int readInt() throws IOException {
        int b0, b1, b2, b3;
        int n;
        b0 = in.read();
        b1 = in.read();
        b2 = in.read();
        b3 = in.read();
        if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0)
            throw new EOFException();
        n = (b3 & 0x0ff);
        n |= (b2 & 0x0ff) << 8;
        n |= (b1 & 0x0ff) << 16;
        n |= (b0 & 0x0ff) << 24;
        return n;
    }

    void readFully(byte[] buf) throws IOException {
        int len = buf.length;
        int offset = 0;
        int value;
        while (len > 0) {
            value = in.read(buf, offset, len);
            if (value == -1)
                throw new EOFException("read buffer");
            offset += value;
            len -= value;
        }
    }

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

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    static boolean compareRandom = true;

    static int MAX_RECORDSIZE = 16384 * 2;

    void readRandomData() throws IOException {
        int n = readInt();
        byte[] actual = new byte[n];
        readFully(actual);
        if (compareRandom) {
            byte[] expected;
            if (n != nextRecordSize())
                throw new IOException("wrong record size");
            expected = new byte[n];
            prng.nextBytes(expected);
            for (int i = 0; i < n; i++) if (actual[i] != expected[i])
                throw new IOException("random data was incorrect, " + "n = " + n + ", i = " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2384().readRandomData();
    }
}
