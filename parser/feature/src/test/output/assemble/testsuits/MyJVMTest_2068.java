import java.security.cert.*;
import java.io.ByteArrayInputStream;
import java.security.Provider;
import java.security.AuthProvider;

public class MyJVMTest_2068 {

    static String certStr = "2#=&VV4[&:";

    static CertificateFactorySpi cfParam1 = null;

    static String cfParam2Param1 = "n`}:rZ T;z";

    static double cfParam2Param2 = Double.MIN_VALUE;

    static String cfParam2Param3 = "6b:{q.alXP";

    static Provider cfParam2 = new AuthProvider(cfParam2Param1, cfParam2Param2, cfParam2Param3);

    static String cfParam3 = ",<d?iyxJ.e";

    static CertificateFactory cf = new CertificateFactory(cfParam1, cfParam2, cfParam3);

    X509Certificate generateCert(String certStr, CertificateFactory cf) throws Exception {
        ByteArrayInputStream stream = new ByteArrayInputStream(certStr.getBytes());
        return (X509Certificate) cf.generateCertificate(stream);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2068().generateCert(certStr, cf));
    }
}
