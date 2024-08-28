import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import java.security.cert.*;
import javax.net.*;
import javax.net.ssl.*;

public class MyJVMTest_13622 {

    static String[] args = { "nLT-cH#aWG", ")=3!p2I u2", "nd-SY):9V2", "%y1I%GHaKM", "q##TR\"V/\\1", "s~Vw$D1,ws", "-5tYJ}C@Zz", "U.dR#fB]Gq", "o32:p8\"?eb", "It*AIy}\\Nh" };

    static boolean separateServerThread = false;

    static Exception serverException = null;

    static Exception clientException = null;

    static String keyAlias = ".8GQ/SS7;j";

    static int keySize = 319618748;

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
        new MyJVMTest_13622().parseArguments(args);
    }
}
