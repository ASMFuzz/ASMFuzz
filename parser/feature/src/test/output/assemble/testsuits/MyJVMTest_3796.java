import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_3796 {

    static int got = 0;

    static int expected = 6;

    static String msg = "sE9eg@`tx]";

    static boolean separateServerThread = true;

    static boolean VERBOSE = true;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    int expectValue(int got, int expected, String msg) throws IOException {
        if (VERBOSE) {
            System.err.println(msg + ": read (" + got + ")");
        }
        if (got != expected) {
            throw new IOException(msg + ": read (" + got + ") but expecting(" + expected + ")");
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3796().expectValue(got, expected, msg);
    }
}
