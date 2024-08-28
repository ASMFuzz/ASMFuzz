import java.net.*;
import java.io.*;

public class MyJVMTest_170 {

    static byte[] isParam1 = { -12, -107, 39, -100, -79, 125, 52, -102, -7, 105 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    static byte[] buf = { -50, 7, -63, -121, -52, -24, -9, -119, -37, 100 };

    static InputStream in = null;

    static OutputStream out = null;

    static Socket client = null;

    static InputStream tin = null;

    static OutputStream tout = null;

    int readBuf(InputStream is, byte[] buf) throws IOException {
        int l = buf.length;
        int count = 0;
        int i;
        do {
            i = is.read(buf, count, l - count);
            if (i == -1)
                throw new IOException("unexpected EOF");
            count += i;
        } while (count < l);
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_170().readBuf(is, buf);
    }
}
