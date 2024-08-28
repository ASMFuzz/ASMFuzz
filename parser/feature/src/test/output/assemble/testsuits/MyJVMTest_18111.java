import java.io.*;
import java.util.*;
import java.security.cert.*;
import java.security.cert.CertPathValidatorException.*;

public class MyJVMTest_18111 {

    static String selfSignedCertStr = null;

    CertPath generateCertificatePath() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is;
        is = new ByteArrayInputStream(selfSignedCertStr.getBytes());
        Certificate selfSignedCert = cf.generateCertificate(is);
        List<Certificate> list = Arrays.asList(new Certificate[] { selfSignedCert });
        return cf.generateCertPath(list);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18111().generateCertificatePath());
    }
}
