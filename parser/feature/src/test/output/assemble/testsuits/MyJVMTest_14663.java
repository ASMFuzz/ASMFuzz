import java.net.*;
import java.io.*;

public class MyJVMTest_14663 {

    static byte[] isParam1 = { 24, 33, -49, -63, -6, -6, 109, 58, 43, 20 };

    static int isParam2 = 534;

    static int isParam3 = 227;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    static byte[] buf = { 40, -96, -117, 35, 123, 44, -98, 14, 94, 92 };

    static int DEFAULT_PORT = 1080;

    static int port = 1;

    static ServerSocket server = null;

    static boolean useV4 = false;

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
        new MyJVMTest_14663().readBuf(is, buf);
    }
}
