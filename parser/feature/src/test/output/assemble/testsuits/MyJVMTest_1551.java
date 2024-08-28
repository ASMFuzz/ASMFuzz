import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.*;
import java.security.*;
import com.sun.net.ssl.*;

public class MyJVMTest_1551 {

    static X509Certificate[] chain = { null, null, null, null, null, null, null, null, null, null };

    static boolean clientChecked = false;

    boolean isClientTrusted(X509Certificate[] chain) {
        clientChecked = true;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1551().isClientTrusted(chain));
    }
}
