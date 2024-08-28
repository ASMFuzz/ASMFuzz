import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_6273 {

    static String keyType = "~S{r>@npqY";

    static Principal[] issuers = { null, null, null, null, null, null, null, null, null, null };

    static SSLEngine engine = null;

    static X509ExtendedKeyManager keyManager = null;

    String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
        throw new UnsupportedOperationException("Servers not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6273().chooseEngineServerAlias(keyType, issuers, engine));
    }
}
