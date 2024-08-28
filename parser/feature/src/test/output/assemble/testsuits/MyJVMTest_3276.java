import java.io.*;

public class MyJVMTest_3276 {

    static int len = 8;

    static String enc = "v+gv`Ya /J";

    static PrintStream log = System.err;

    static int failures = 0;

    static ByteArrayOutputStream bos = new ByteArrayOutputStream(1 << 15);

    int go(int len, String enc) throws Exception {
        bos.reset();
        OutputStreamWriter osw = new OutputStreamWriter(bos, enc);
        char[] cs = new char[len];
        osw.write(cs);
        osw.close();
        byte[] ba = bos.toByteArray();
        if (ba.length != len) {
            log.println("FAIL: Wrote " + len + ", got " + ba.length + "; enc = " + enc);
            failures++;
        }
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3276().go(len, enc);
    }
}
