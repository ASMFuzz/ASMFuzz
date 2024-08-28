import java.net.*;
import java.io.*;
import java.nio.channels.*;

public class MyJVMTest_5825 {

    static OutputStream out = new ByteArrayOutputStream();

    static byte[] inParam1 = { -111, -111, 61, -98, 79, 125, 111, 0, 54, -87 };

    static InputStream in = new ByteArrayInputStream(inParam1);

    int testConnection(OutputStream out, InputStream in) throws IOException {
        byte[] msg = "hello".getBytes();
        out.write(msg);
        byte[] ba = new byte[100];
        int nread = 0;
        while (nread < msg.length) {
            int n = in.read(ba);
            if (n < 0)
                throw new IOException("EOF not expected!");
            nread += n;
        }
        return nread;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5825().testConnection(out, in);
    }
}
