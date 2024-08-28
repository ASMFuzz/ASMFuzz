import java.io.*;
import java.security.*;

public class MyJVMTest_16875 {

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16875().readInt());
    }
}
