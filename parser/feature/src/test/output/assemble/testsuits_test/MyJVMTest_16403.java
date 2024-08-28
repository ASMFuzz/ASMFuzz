import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16403 {

    static CharsetEncoder ce = null;

    static String s = "-QDbw4!iOM";

    static boolean can = true;

    void wrong(CharsetEncoder ce, boolean can, String what) {
        out.println(ce.charset().name() + ": Wrong answer for " + what + ": " + !can);
        errors++;
    }

    static int errors = 0;

    static PrintStream out = System.err;

    String ck(CharsetEncoder ce, String s, boolean can) throws Exception {
        if (ce.canEncode(CharBuffer.wrap(s.toCharArray())) != can)
            wrong(ce, can, "array \"" + s + "\"");
        if (ce.canEncode(CharBuffer.wrap(s)) != can)
            wrong(ce, can, "buffer  \"" + s + "\"");
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16403().ck(ce, s, can);
    }
}
