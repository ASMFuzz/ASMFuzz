import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_6021 {

    static CRC32 crc32 = new CRC32();

    static ByteBuffer buf = null;

    static int iters = 442439459;

    long time(CRC32 crc32, ByteBuffer buf, int iters) {
        long start_t = System.nanoTime();
        for (int i = 0; i < iters; i++) {
            crc32.reset();
            buf.mark();
            crc32.update(buf);
            buf.reset();
        }
        long t = System.nanoTime() - start_t;
        System.out.printf("%,12d", t / buf.remaining());
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6021().time(crc32, buf, iters));
    }
}
