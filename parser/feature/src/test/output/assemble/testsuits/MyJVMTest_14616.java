import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.*;
import java.security.*;
import com.sun.net.ssl.*;

public class MyJVMTest_14616 {

    static X509Certificate[] chain = { null, null, null, null, null, null, null, null, null, null };

    static boolean separateServerThread = true;

    static boolean clientChecked = true;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    boolean isClientTrusted(X509Certificate[] chain) {
        clientChecked = true;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14616().isClientTrusted(chain));
    }
}
