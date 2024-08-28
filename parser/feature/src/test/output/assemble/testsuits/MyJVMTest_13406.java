import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_13406 {

    static String keyType = "q;wD#8FR)x";

    static Principal[] issuers = { null, null, null, null, null, null, null, null, null, null };

    static String socketParam1 = "_i+8`6|&hM";

    static int socketParam2 = 272;

    static InetAddress socketParam3 = null;

    static int socketParam4 = 860;

    static Socket socket = new Socket(socketParam1, socketParam2, socketParam3, socketParam4);

    static X509ExtendedKeyManager keyManager = null;

    String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        throw new UnsupportedOperationException("Servers not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13406().chooseServerAlias(keyType, issuers, socket));
    }
}
