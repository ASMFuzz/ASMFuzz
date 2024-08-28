import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_13405 {

    static Adler32 adler32 = new Adler32();

    static ByteBuffer buf = null;

    static int iters = -534136121;

    long time(Adler32 adler32, ByteBuffer buf, int iters) {
        long start_t = System.nanoTime();
        for (int i = 0; i < iters; i++) {
            adler32.reset();
            buf.mark();
            adler32.update(buf);
            buf.reset();
        }
        long t = System.nanoTime() - start_t;
        System.out.printf("%,12d", t / buf.remaining());
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13405().time(adler32, buf, iters));
    }
}
