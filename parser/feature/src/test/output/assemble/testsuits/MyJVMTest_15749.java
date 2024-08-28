import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_15749 {

    static String keyType = "oYMrKt#-By";

    static Principal[] issuers = { null, null, null, null, null, null, null, null, null, null };

    static SSLEngine engine = null;

    static X509ExtendedKeyManager keyManager = null;

    String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
        throw new UnsupportedOperationException("Servers not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15749().chooseEngineServerAlias(keyType, issuers, engine));
    }
}
