import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_598 {

    static String keyStoreFile = "keystore";

    static String trustStoreFile = "truststore";

    static String pathToStores = "1|gCmY,$(k";

    static String keyFilename = "*]<0>'anw/";

    static String trustFilename = "#!K71#G]:`";

    String init(String pathToStores) {
        this.pathToStores = pathToStores;
        this.keyFilename = System.getProperty("test.src", "./") + "/" + pathToStores + "/" + keyStoreFile;
        this.trustFilename = System.getProperty("test.src", "./") + "/" + pathToStores + "/" + trustStoreFile;
        return pathToStores;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_598().init(pathToStores);
    }
}
