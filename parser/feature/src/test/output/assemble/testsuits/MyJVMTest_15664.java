import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_15664 {

    static Adler32 adler32 = new Adler32();

    static byte[] data = { -32, 115, 47, -108, -114, -79, -30, 45, 26, 99 };

    static int iters = 0;

    static int len = 7;

    long time(Adler32 adler32, byte[] data, int iters, int len) {
        long start_t = System.nanoTime();
        for (int i = 0; i < iters; i++) {
            adler32.reset();
            adler32.update(data, 0, len);
        }
        long t = System.nanoTime() - start_t;
        System.out.printf("%,12d", t / len);
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15664().time(adler32, data, iters, len));
    }
}
