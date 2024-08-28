import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_15420 {

    static String file = "9$lDIF~C|H";

    static String type = "R$0yW:6$z\"";

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
        new MyJVMTest_15420().init(file, type, key);
    }
}
