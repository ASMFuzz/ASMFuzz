import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_10690 {

    static String pathToStores = "../etc";

    static String keyStoreFile = "keystore";

    static String trustStoreFile = "truststore";

    static String passwd = "passphrase";

    static int serverPort = 0;

    void run() {
        try {
            new Socket("localhost", serverPort);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10690().run();
    }
}
