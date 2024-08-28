import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.*;
import java.util.Arrays;

public class MyJVMTest_13806 {

    X509Certificate[] getAcceptedIssuers() {
        return (new X509Certificate[0]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13806().getAcceptedIssuers()));
    }
}
