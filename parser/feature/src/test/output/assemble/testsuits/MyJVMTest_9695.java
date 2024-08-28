import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_9695 {

    static String tsPath = "o|7b()/g-*";

    static char[] pass = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '.', '0', '0', Character.MAX_VALUE, 'S', '6' };

    TrustManagerFactory makeTrustManagerFactory(String tsPath, char[] pass) throws GeneralSecurityException, IOException {
        TrustManagerFactory tmf;
        KeyStore ts = KeyStore.getInstance("JKS");
        try (FileInputStream fsIn = new FileInputStream(tsPath)) {
            ts.load(fsIn, pass);
            tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ts);
        }
        return tmf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9695().makeTrustManagerFactory(tsPath, pass));
    }
}
