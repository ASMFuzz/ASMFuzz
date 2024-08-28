import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_16267 {

    static String name = "V)[_/tM'iN";

    static String BASE = System.getProperty("test.src");

    static CertificateFactory factory = null;

    static String resultTree = "mp/j1D64=|";

    static Set initialPolicies = new HashSet();

    X509Certificate loadCertificate(String name) throws Exception {
        InputStream in = new FileInputStream(new File(BASE, name));
        X509Certificate cert = (X509Certificate) factory.generateCertificate(in);
        in.close();
        return cert;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16267().loadCertificate(name));
    }
}
