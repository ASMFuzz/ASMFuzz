import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_5965 {

    static String file = "n\\vB)n^'zq";

    static String type = "ng/]2=yx/3";

    static SecretKey key = null;

    static char[] PASSWORD = "changeit".toCharArray();

    static ProtectionParameter protection = null;

    KeyStore init(String file, String type, SecretKey key) throws Exception {
        KeyStore ks = KeyStore.getInstance(type);
        ks.load(null, null);
        ks.setEntry("mykey", new KeyStore.SecretKeyEntry(key), new PasswordProtection(PASSWORD));
        try (OutputStream stream = new FileOutputStream(file)) {
            ks.store(stream, PASSWORD);
        }
        System.out.println("Created a " + type + " keystore named '" + file + "'");
        return ks;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5965().init(file, type, key);
    }
}
