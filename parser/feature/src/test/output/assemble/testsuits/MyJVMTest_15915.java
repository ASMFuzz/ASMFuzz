import java.util.*;
import java.security.*;
import java.security.cert.*;
import java.io.*;

public class MyJVMTest_15915 {

    static String s = "@O),&09)tQ";

    static CertificateFactory cf = null;

    X509Certificate parseCert(String s) throws Exception {
        if (cf == null) {
            cf = CertificateFactory.getInstance("X.509");
        }
        InputStream in = new ByteArrayInputStream(s.getBytes("UTF8"));
        return (X509Certificate) cf.generateCertificate(in);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15915().parseCert(s));
    }
}
