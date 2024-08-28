import java.io.*;
import java.security.*;

public class MyJVMTest_4852 {

    static int n = 4;

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    int writeInt(int n) throws IOException {
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
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4852().writeInt(n);
    }
}
