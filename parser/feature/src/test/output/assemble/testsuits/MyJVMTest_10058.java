import java.io.*;
import java.util.*;
import java.security.cert.*;
import java.security.cert.CertPathValidatorException.*;

public class MyJVMTest_10058 {

    static String certStr = "$0&Q\\o1~[w";

    CertPath generateCertificatePath(String certStr) throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is;
        is = new ByteArrayInputStream(certStr.getBytes());
        Certificate cert = cf.generateCertificate(is);
        List<Certificate> list = Arrays.asList(new Certificate[] { cert });
        return cf.generateCertPath(list);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10058().generateCertificatePath(certStr));
    }
}
