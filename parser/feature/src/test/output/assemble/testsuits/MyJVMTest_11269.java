import java.io.*;
import java.util.*;
import java.security.cert.*;
import java.security.cert.CertPathValidatorException.*;

public class MyJVMTest_11269 {

    static String castr = "t2S?3k@uFv";

    static String eestr = "m!IOG|H,Mm";

    CertPath generateCertificatePath(String castr, String eestr) throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is;
        is = new ByteArrayInputStream(castr.getBytes());
        Certificate cacert = cf.generateCertificate(is);
        is = new ByteArrayInputStream(eestr.getBytes());
        Certificate eecert = cf.generateCertificate(is);
        List<Certificate> list = Arrays.asList(new Certificate[] { eecert, cacert });
        return cf.generateCertPath(list);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11269().generateCertificatePath(castr, eestr));
    }
}
