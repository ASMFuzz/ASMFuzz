import java.security.cert.*;
import java.security.Provider;
import java.security.AuthProvider;
import java.util.HashSet;

public class MyJVMTest_5290 {

    static CertPathBuilderSpi cpbParam1 = null;

    static String cpbParam2Param1 = "otw)%GsM~q";

    static double cpbParam2Param2 = Double.MIN_VALUE;

    static String cpbParam2Param3 = "_KH5!~Uk)s";

    static Provider cpbParam2 = new AuthProvider(cpbParam2Param1, cpbParam2Param2, cpbParam2Param3);

    static String cpbParam3 = "->o!Z?NAN>";

    static CertPathBuilder cpb = new CertPathBuilder(cpbParam1, cpbParam2, cpbParam3);

    static Set<TrustAnchor> paramsParam1 = new HashSet<TrustAnchor>();

    static CertSelector paramsParam2 = null;

    static PKIXBuilderParameters params = new PKIXBuilderParameters(paramsParam1, paramsParam2);

    CertPath buildCertPath(CertPathBuilder cpb, PKIXBuilderParameters params) throws Exception {
        CertPathBuilderResult res = cpb.build(params);
        if (res.getCertPath().getCertificates().size() != 0) {
            throw new Exception("built path is not zero-length");
        }
        return res.getCertPath();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5290().buildCertPath(cpb, params));
    }
}
