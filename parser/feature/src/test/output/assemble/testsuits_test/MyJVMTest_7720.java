import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.*;
import java.security.*;
import com.sun.net.ssl.*;

public class MyJVMTest_7720 {

    static X509Certificate[] chain = { null, null, null, null, null, null, null, null, null, null };

    static boolean serverChecked = false;

    boolean isServerTrusted(X509Certificate[] chain) {
        serverChecked = true;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7720().isServerTrusted(chain));
    }
}
