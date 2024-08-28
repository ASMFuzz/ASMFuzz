import java.io.*;
import java.util.*;

public class MyJVMTest_11327 {

    static byte[] sParam1 = { -73, -80, 15, -122, -10, -102, 105, -85, -63, -70 };

    static int sParam2 = 739;

    static int sParam3 = 587;

    static InputStream s = new ByteArrayInputStream(sParam1, sParam2, sParam3);

    static byte[] buf = { -28, 53, 34, -61, 34, 124, 24, 86, -8, 27 };

    int readFully(InputStream s, byte[] buf) throws Throwable {
        int pos = 0;
        int n;
        while ((n = s.read(buf, pos, buf.length - pos)) > 0) pos += n;
        if (pos != buf.length)
            throw new Exception("Unexpected EOF");
        return pos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11327().readFully(s, buf);
    }
}
