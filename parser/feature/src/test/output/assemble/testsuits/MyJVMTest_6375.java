import java.io.*;
import java.security.*;

public class MyJVMTest_6375 {

    static KeyStoreSpi keyStoreParam1 = null;

    static String keyStoreParam2Param1 = "|wp?Wx-_ya";

    static double keyStoreParam2Param2 = 0d;

    static String keyStoreParam2Param3 = ")cYRSVe(\"+";

    static Provider keyStoreParam2 = new AuthProvider(keyStoreParam2Param1, keyStoreParam2Param2, keyStoreParam2Param3);

    static String keyStoreParam3 = "&]-k9=CWW:";

    static KeyStore keyStore = new KeyStore(keyStoreParam1, keyStoreParam2, keyStoreParam3);

    static Object stream = 2;

    static char[] password = { '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, 'F', '^', '0', '$' };

    static boolean doLoad = true;

    static boolean mode = false;

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
        new MyJVMTest_6375().testLoadStore(keyStore, stream, password, doLoad);
    }
}
