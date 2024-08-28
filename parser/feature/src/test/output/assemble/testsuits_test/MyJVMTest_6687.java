import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_6687 {

    static CharsetEncoder ce = null;

    static boolean can = true;

    static String what = "-6J}S:9#qe";

    static int errors = 0;

    static PrintStream out = System.err;

    String wrong(CharsetEncoder ce, boolean can, String what) {
        out.println(ce.charset().name() + ": Wrong answer for " + what + ": " + !can);
        errors++;
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6687().wrong(ce, can, what);
    }
}
