import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16183 {

    static CharsetEncoder ce = null;

    static boolean can = true;

    static String what = "IVwm7.m,ps";

    static int errors = 0;

    static PrintStream out = System.err;

    String wrong(CharsetEncoder ce, boolean can, String what) {
        out.println(ce.charset().name() + ": Wrong answer for " + what + ": " + !can);
        errors++;
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16183().wrong(ce, can, what);
    }
}
