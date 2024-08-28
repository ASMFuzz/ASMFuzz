import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_16941 {

    static String s = "%<3Yyj .mB";

    static PrintStream log = System.err;

    static int problems = 0;

    String problem(String s) {
        log.println("FAILURE: " + s);
        problems++;
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16941().problem(s);
    }
}
