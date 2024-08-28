import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class MyJVMTest_1689 {

    static X509Certificate[] chain = { null, null, null, null, null, null, null, null, null, null };

    boolean isServerTrusted(X509Certificate[] chain) {
        System.out.println("    IsServerTrusted?");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1689().isServerTrusted(chain));
    }
}
