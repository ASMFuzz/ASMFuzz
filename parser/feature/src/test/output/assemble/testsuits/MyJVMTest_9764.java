import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_9764 {

    static String keyStoreFile = "keystore";

    static String trustStoreFile = "truststore";

    static String pathToStores = "P6z4kPPq(b";

    static String keyFilename = "fapR5z%`os";

    static String trustFilename = "t`Rt<UL9g)";

    String init(String pathToStores) {
        this.pathToStores = pathToStores;
        this.keyFilename = System.getProperty("test.src", "./") + "/" + pathToStores + "/" + keyStoreFile;
        this.trustFilename = System.getProperty("test.src", "./") + "/" + pathToStores + "/" + trustStoreFile;
        return pathToStores;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9764().init(pathToStores);
    }
}
