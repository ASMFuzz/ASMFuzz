import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_2084 {

    static int got = 0;

    static int expected = 1294574103;

    static String msg = "k1Td-G$-*a";

    static boolean separateServerThread = true;

    static boolean VERBOSE = false;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    int expectValue(int got, int expected, String msg) throws IOException {
        if (VERBOSE) {
            System.out.println(msg + ": read (" + got + ")");
        }
        if (got != expected) {
            throw new IOException(msg + ": read (" + got + ") but expecting(" + expected + ")");
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2084().expectValue(got, expected, msg);
    }
}
