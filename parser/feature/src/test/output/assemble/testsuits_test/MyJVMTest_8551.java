import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_8551 {

    static CRC32 crc32 = new CRC32();

    static byte[] data = { 89, 22, -43, 25, 34, -22, 57, 112, 21, 38 };

    static int iters = 7;

    static int len = 5;

    long time(CRC32 crc32, byte[] data, int iters, int len) {
        long start_t = System.nanoTime();
        for (int i = 0; i < iters; i++) {
            crc32.reset();
            crc32.update(data, 0, len);
        }
        long t = System.nanoTime() - start_t;
        System.out.printf("%,12d", t / len);
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8551().time(crc32, data, iters, len));
    }
}
