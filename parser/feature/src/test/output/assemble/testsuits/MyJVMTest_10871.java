import java.io.*;

public class MyJVMTest_10871 {

    static int off = 5;

    static int len = 7;

    static boolean expected = true;

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
        new MyJVMTest_10871().testRead(off, len, expected);
    }
}
