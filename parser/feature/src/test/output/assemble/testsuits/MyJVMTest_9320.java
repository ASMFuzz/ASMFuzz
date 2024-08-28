import java.net.*;
import java.io.*;

public class MyJVMTest_9320 {

    static byte[] isParam1 = { 119, -20, -51, 69, 2, 124, 41, 125, -110, 60 };

    static int isParam2 = 209;

    static int isParam3 = 974;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    static byte[] buf = { -55, 35, 103, -46, -123, -77, 17, 117, -87, 70 };

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
        new MyJVMTest_9320().readBuf(is, buf);
    }
}
