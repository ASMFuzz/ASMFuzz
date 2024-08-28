import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_6191 {

    static Adler32 adler32 = new Adler32();

    static byte[] data = { -15, -16, -121, 125, 12, -79, -108, -108, 95, 79 };

    static int iters = 0;

    static int len = 321380843;

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
        System.out.println(new MyJVMTest_6191().time(adler32, data, iters, len));
    }
}
