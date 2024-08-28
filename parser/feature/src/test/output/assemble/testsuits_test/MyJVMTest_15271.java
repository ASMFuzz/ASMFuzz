import java.net.*;
import java.io.*;
import java.nio.channels.*;

public class MyJVMTest_15271 {

    static int outParam1 = 630;

    static OutputStream out = new ByteArrayOutputStream(outParam1);

    static byte[] inParam1 = { 63, -101, -4, 60, 17, 10, -112, -93, 21, -97 };

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
        new MyJVMTest_15271().testConnection(out, in);
    }
}
