import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_13735 {

    static String ksPath = "fdV/5jNr<l";

    static char[] pass = { Character.MAX_VALUE, Character.MAX_VALUE, 'c', '0', ';', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    KeyManagerFactory makeKeyManagerFactory(String ksPath, char[] pass) throws GeneralSecurityException, IOException {
        KeyManagerFactory kmf;
        KeyStore ks = KeyStore.getInstance("JKS");
        try (FileInputStream fsIn = new FileInputStream(ksPath)) {
            ks.load(fsIn, pass);
            kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, pass);
        }
        return kmf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13735().makeKeyManagerFactory(ksPath, pass));
    }
}
