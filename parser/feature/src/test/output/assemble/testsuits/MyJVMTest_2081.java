import java.io.*;
import java.util.*;

public class MyJVMTest_2081 {

    static byte[] sParam1 = { 23, -125, -112, 11, -9, -65, 37, -66, 4, -74 };

    static InputStream s = new ByteArrayInputStream(sParam1);

    static byte[] buf = { -26, 91, -21, 91, 118, -113, -28, -31, 107, -75 };

    int readFully(InputStream s, byte[] buf) throws Throwable {
        int pos = 0;
        int n;
        while ((n = s.read(buf, pos, buf.length - pos)) > 0) pos += n;
        if (pos != buf.length)
            throw new Exception("Unexpected EOF");
        return pos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2081().readFully(s, buf);
    }
}
