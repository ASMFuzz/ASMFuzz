import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_17413 {

    static String pathToStores = "../etc";

    static String keyStoreFile = "keystore";

    static String trustStoreFile = "truststore";

    static String passwd = "passphrase";

    static int serverPort = 0;

    Thread forkClient() {
        Thread clientThread = new Thread() {

            public void run() {
                try {
                    new Socket("localhost", serverPort);
                } catch (Exception e) {
                }
            }
        };
        clientThread.start();
        return clientThread;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17413().run();
    }
}
