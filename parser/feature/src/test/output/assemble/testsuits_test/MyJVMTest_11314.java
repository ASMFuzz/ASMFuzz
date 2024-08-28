import java.security.cert.*;
import java.io.ByteArrayInputStream;
import java.security.Provider;
import java.security.AuthProvider;

public class MyJVMTest_11314 {

    static String certStr = "n{gc'Z6M$q";

    static CertificateFactorySpi cfParam1 = null;

    static String cfParam2Param1 = "C[2nN\\[=^L";

    static double cfParam2Param2 = 0d;

    static String cfParam2Param3 = "5$^.Nh17HQ";

    static Provider cfParam2 = new AuthProvider(cfParam2Param1, cfParam2Param2, cfParam2Param3);

    static String cfParam3 = "T65[r-=yZY";

    static CertificateFactory cf = new CertificateFactory(cfParam1, cfParam2, cfParam3);

    X509Certificate generateCert(String certStr, CertificateFactory cf) throws Exception {
        ByteArrayInputStream stream = new ByteArrayInputStream(certStr.getBytes());
        return (X509Certificate) cf.generateCertificate(stream);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11314().generateCert(certStr, cf));
    }
}
