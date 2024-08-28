import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_7409 {

    static String s = "b{]WVPb=k<";

    static PrintStream log = System.err;

    static int problems = 0;

    String problem(String s) {
        log.println("FAILURE: " + s);
        problems++;
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7409().problem(s);
    }
}
