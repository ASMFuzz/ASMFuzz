import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_4361 {

    static String ksPath = "uoA!VM.m4P";

    static char[] pass = { 'b', 'P', Character.MIN_VALUE, '0', 'i', Character.MAX_VALUE, '0', 'e', Character.MAX_VALUE, '0' };

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
        System.out.println(new MyJVMTest_4361().makeKeyManagerFactory(ksPath, pass));
    }
}
