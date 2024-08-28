import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_13137 {

    static int got = 0;

    static int expected = 631368874;

    static String msg = ".b7UVvLtBk";

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
        new MyJVMTest_13137().expectValue(got, expected, msg);
    }
}
