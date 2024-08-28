import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_4991 {

    static String file = "?x2t:EGd0i";

    static String type = "G^Sj~|;Y2[";

    static X509Certificate cert = null;

    static char[] PASSWORD = "changeit".toCharArray();

    static ProtectionParameter protection = null;

    KeyStore init(String file, String type, X509Certificate cert) throws Exception {
        KeyStore ks = KeyStore.getInstance(type);
        ks.load(null, null);
        ks.setEntry("mycert", new KeyStore.TrustedCertificateEntry(cert), null);
        try (OutputStream stream = new FileOutputStream(file)) {
            ks.store(stream, PASSWORD);
        }
        System.out.println("Created a " + type + " keystore named '" + file + "'");
        return ks;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4991().init(file, type, cert);
    }
}
