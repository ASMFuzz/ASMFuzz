import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import java.security.cert.*;
import javax.net.*;
import javax.net.ssl.*;

public class MyJVMTest_4255 {

    static String[] args = { "?\"Z/*^F6v_", "=x)-4-NaT@", "y'~[8\\j,j ", "i'dM, S',@", "=9-8}Wa>HQ", "0G9n\\kYBKV", "&:s.mm,KXK", "EysjoE9VVL", ".#>EpZ|<ok", "^ue|K LF<Q" };

    static boolean separateServerThread = false;

    static Exception serverException = null;

    static Exception clientException = null;

    static String keyAlias = "gOipAJNKij";

    static int keySize = 0;

    static String clientProtocol = null;

    static String clientCiperSuite = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    static X509TrustManager tm = null;

    String[] parseArguments(String[] args) {
        keyAlias = args[0];
        keySize = Integer.parseInt(args[1]);
        if (args.length > 2) {
            clientProtocol = args[2];
        }
        if (args.length > 3) {
            clientCiperSuite = args[3];
        }
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4255().parseArguments(args);
    }
}
