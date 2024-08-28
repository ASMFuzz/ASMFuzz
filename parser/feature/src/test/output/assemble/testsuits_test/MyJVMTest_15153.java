import java.io.*;
import java.util.*;
import java.security.cert.*;
import java.security.cert.CertPathValidatorException.*;

public class MyJVMTest_15153 {

    static String selfSignedCertStr = null;

    Set<TrustAnchor> generateTrustAnchors() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is = new ByteArrayInputStream(selfSignedCertStr.getBytes());
        Certificate selfSignedCert = cf.generateCertificate(is);
        TrustAnchor anchor = new TrustAnchor((X509Certificate) selfSignedCert, null);
        return Collections.singleton(anchor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15153().generateTrustAnchors());
    }
}
