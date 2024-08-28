import java.io.*;

public class MyJVMTest_1649 {

    static int off = -150158298;

    static int len = 6;

    static boolean expected = false;

    static FileInputStream fis = null;

    static RandomAccessFile raf = null;

    static byte[] b = new byte[32];

    int testRead(int off, int len, boolean expected) throws Throwable {
        System.err.printf("off=%d len=%d expected=%b%n", off, len, expected);
        boolean result;
        try {
            fis.read(b, off, len);
            raf.read(b, off, len);
            result = true;
        } catch (IndexOutOfBoundsException e) {
            result = false;
        }
        if (result != expected) {
            throw new RuntimeException(String.format("Unexpected result off=%d len=%d expected=%b", off, len, expected));
        }
        return off;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1649().testRead(off, len, expected);
    }
}
