import java.io.*;
import java.security.*;

public class MyJVMTest_2127 {

    static byte[] buf = { 41, 64, -18, -108, -68, -89, 83, -9, 59, -13 };

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    int readFully(byte[] buf) throws IOException {
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
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2127().readFully(buf);
    }
}
