import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class MyJVMTest_4131 {

    static X509Certificate[] chain = { null, null, null, null, null, null, null, null, null, null };

    boolean isClientTrusted(X509Certificate[] chain) {
        System.out.println("    IsClientTrusted?");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4131().isClientTrusted(chain));
    }
}
