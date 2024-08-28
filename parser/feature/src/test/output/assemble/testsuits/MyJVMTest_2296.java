import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;

public class MyJVMTest_2296 {

    static String BASE = System.getProperty("test.src", ".");

    static char[] password = "test12".toCharArray();

    KeyStore getKeyStore() throws Exception {
        InputStream in = new FileInputStream(new File(BASE, "rsakeys.ks"));
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(in, password);
        in.close();
        return ks;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2296().getKeyStore());
    }
}
