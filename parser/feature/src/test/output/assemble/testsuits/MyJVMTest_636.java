import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;
import java.util.concurrent.*;
import sun.security.x509.*;

public class MyJVMTest_636 {

    static byte[] isParam1 = { 62, 103, 12, -67, -6, 30, 43, -52, -36, -9 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    static Socket sock = null;

    String readLine(InputStream is) throws IOException {
        PushbackInputStream pbis = new PushbackInputStream(is);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        boolean done = false;
        while (!done) {
            byte b = (byte) pbis.read();
            if (b == '\r') {
                byte bNext = (byte) pbis.read();
                if (bNext == '\n' || bNext == -1) {
                    done = true;
                } else {
                    pbis.unread(bNext);
                    bos.write(b);
                }
            } else if (b == -1) {
                done = true;
            } else {
                bos.write(b);
            }
        }
        return new String(bos.toByteArray(), "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_636().readLine(is));
    }
}
