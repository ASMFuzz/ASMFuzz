import java.io.*;
import java.security.*;

public class MyJVMTest_4115 {

    static InputStream in = null;

    static OutputStream out = null;

    static byte[] fixedSeed = { 1, 2, 3, 4 };

    static SecureRandom prng = null;

    static boolean compareRandom = true;

    SecureRandom setPRNG(SecureRandom prng) {
        this.prng = prng;
        compareRandom = false;
        return prng;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4115().setPRNG(prng);
    }
}
