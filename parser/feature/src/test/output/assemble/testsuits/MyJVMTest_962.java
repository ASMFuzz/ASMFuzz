import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.*;
import java.security.*;
import com.sun.net.ssl.*;

public class MyJVMTest_962 {

    static X509Certificate[] chain = { null, null, null, null, null, null, null, null, null, null };

    static boolean separateServerThread = true;

    static boolean serverChecked = true;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    boolean isServerTrusted(X509Certificate[] chain) {
        serverChecked = true;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_962().isServerTrusted(chain));
    }
}
