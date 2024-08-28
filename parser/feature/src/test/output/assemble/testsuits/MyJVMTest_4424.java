import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.*;
import java.util.Arrays;

public class MyJVMTest_4424 {

    X509Certificate[] getAcceptedIssuers() {
        return (new X509Certificate[0]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4424().getAcceptedIssuers()));
    }
}
