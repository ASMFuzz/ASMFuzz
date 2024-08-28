import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_8180 {

    static String file = "Nb%`b|O&P6";

    static String type = ",bTgvpx:Y.";

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
        new MyJVMTest_8180().init(file, type);
    }
}
