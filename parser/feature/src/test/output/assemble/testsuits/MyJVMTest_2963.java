import java.io.*;
import java.net.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_2963 {

    static String name = "eC!3Xkbgzq";

    static File baseDir = new File(System.getProperty("test.src", "."));

    X509Certificate loadCertificate(String name) throws Exception {
        File certFile = new File(baseDir, name);
        InputStream in = new FileInputStream(certFile);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(in);
        return cert;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2963().loadCertificate(name));
    }
}
