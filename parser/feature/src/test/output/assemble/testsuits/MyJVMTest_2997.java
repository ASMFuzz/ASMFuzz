import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_2997 {

    static String keyType = "*u'iW,q)lU";

    static Principal[] issuers = { null, null, null, null, null, null, null, null, null, null };

    static X509ExtendedKeyManager keyManager = null;

    String[] getServerAliases(String keyType, Principal[] issuers) {
        throw new UnsupportedOperationException("Servers not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2997().getServerAliases(keyType, issuers)));
    }
}
