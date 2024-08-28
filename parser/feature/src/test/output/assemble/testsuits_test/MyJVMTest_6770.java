import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_6770 {

    static String name = "@\"-gd+85 >";

    static String BASE = System.getProperty("test.src");

    static CertificateFactory factory = null;

    static String resultTree = "R'oV\"C0)ii";

    static Set initialPolicies = new HashSet();

    X509Certificate loadCertificate(String name) throws Exception {
        InputStream in = new FileInputStream(new File(BASE, name));
        X509Certificate cert = (X509Certificate) factory.generateCertificate(in);
        in.close();
        return cert;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6770().loadCertificate(name));
    }
}
