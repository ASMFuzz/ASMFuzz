import java.io.*;
import java.security.*;

public class MyJVMTest_15856 {

    static KeyStoreSpi keyStoreParam1 = null;

    static String keyStoreParam2Param1 = "sm{1A#nZKG";

    static double keyStoreParam2Param2 = Double.MAX_VALUE;

    static String keyStoreParam2Param3 = "yrjCi^I! B";

    static Provider keyStoreParam2 = new AuthProvider(keyStoreParam2Param1, keyStoreParam2Param2, keyStoreParam2Param3);

    static String keyStoreParam3 = "qh<_MR#M2<";

    static KeyStore keyStore = new KeyStore(keyStoreParam1, keyStoreParam2, keyStoreParam3);

    static Object stream = 111538654;

    static char[] password = { Character.MAX_VALUE, 'p', '^', '0', '0', '0', Character.MAX_VALUE, 'R', Character.MIN_VALUE, '0' };

    static boolean doLoad = false;

    static boolean mode = true;

    char[] testLoadStore(KeyStore keyStore, Object stream, char[] password, boolean doLoad) throws Exception {
        String streamValue = stream == null ? "null" : "non-null";
        String passwordValue = password == null ? "null" : "non-null";
        System.out.println("Checking " + (doLoad ? "load" : "store") + "(stream=" + streamValue + ", password=" + passwordValue + ")...");
        try {
            if (doLoad) {
                keyStore.load((InputStream) stream, password);
            } else {
                keyStore.store((OutputStream) stream, password);
            }
            if (!mode && keyStore != null && password != null) {
                throw new Exception("Expected an IOException to be thrown by KeyStore.load");
            }
        } catch (IOException ioe) {
            if (mode) {
                throw ioe;
            } else {
                System.out.println("caught the expected exception: " + ioe);
            }
        } catch (KeyStoreException kse) {
            if (doLoad) {
                throw kse;
            } else {
                System.out.println("caught the expected exception: " + kse);
            }
        }
        return password;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15856().testLoadStore(keyStore, stream, password, doLoad);
    }
}
