import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_16537 {

    static byte[] src = { -25, -101, 22, 78, -60, 47, -5, -60, 93, -112 };

    static byte[] dst = { 41, 72, -115, -11, 7, 76, 114, -18, 62, -77 };

    static int readBufSize = 2;

    static int gzisBufSize = 1;

    byte[] test(byte[] src, byte[] dst, int readBufSize, int gzisBufSize) throws Throwable {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(dst);
            GZIPInputStream gzis = new GZIPInputStream(bais, gzisBufSize)) {
            byte[] result = new byte[src.length + 10];
            byte[] buf = new byte[readBufSize];
            int n = 0;
            int off = 0;
            while ((n = gzis.read(buf, 0, buf.length)) != -1) {
                System.arraycopy(buf, 0, result, off, n);
                off += n;
            }
            if (off != src.length || gzis.available() != 0 || !Arrays.equals(src, Arrays.copyOf(result, off))) {
                throw new RuntimeException("GZIPInputStream reading failed! " + ", src.len=" + src.length + ", read=" + off);
            }
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16537().test(src, dst, readBufSize, gzisBufSize);
    }
}
