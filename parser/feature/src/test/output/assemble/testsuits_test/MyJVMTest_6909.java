import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_6909 {

    static String certFile = "ri|@nH (W{";

    static String DIR = System.getProperty("test.src", ".");

    static ProtectionParameter protection = null;

    X509Certificate loadCertificate(String certFile) throws Exception {
        X509Certificate cert = null;
        try (FileInputStream certStream = new FileInputStream(DIR + "/" + certFile)) {
            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            return (X509Certificate) factory.generateCertificate(certStream);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6909().loadCertificate(certFile));
    }
}
