import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_17753 {

    static String file = "-h=7g$S@aj";

    static String type = "dsrth4\"An!";

    static char[] PASSWORD = "changeit".toCharArray();

    static ProtectionParameter protection = null;

    String init(String file, String type) throws Exception {
        KeyStore ks = KeyStore.getInstance(type);
        ks.load(null, null);
        try (OutputStream stream = new FileOutputStream(file)) {
            ks.store(stream, PASSWORD);
        }
        System.out.println("Created a " + type + " keystore named '" + file + "'");
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17753().init(file, type);
    }
}
