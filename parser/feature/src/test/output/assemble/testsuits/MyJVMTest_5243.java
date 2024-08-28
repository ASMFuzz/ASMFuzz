import java.net.*;
import java.io.*;

public class MyJVMTest_5243 {

    static byte[] isParam1 = { -29, -71, 60, -73, 92, 22, 82, -29, -59, 15 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    static byte[] buf = { -120, 2, 92, 121, 44, -73, 36, -42, -3, -77 };

    static int DEFAULT_PORT = 1080;

    static int port = 6;

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
        new MyJVMTest_5243().readBuf(is, buf);
    }
}
