import java.security.cert.*;
import java.security.Provider;
import java.security.AuthProvider;
import java.security.KeyStore;

public class MyJVMTest_14713 {

    static CertPathBuilderSpi cpbParam1 = null;

    static String cpbParam2Param1 = "|s7m]x#+8K";

    static double cpbParam2Param2 = Double.NEGATIVE_INFINITY;

    static String cpbParam2Param3 = ";Z)r?6FIh)";

    static Provider cpbParam2 = new AuthProvider(cpbParam2Param1, cpbParam2Param2, cpbParam2Param3);

    static String cpbParam3 = "YOJw2fVzAB";

    static CertPathBuilder cpb = new CertPathBuilder(cpbParam1, cpbParam2, cpbParam3);

    static KeyStoreSpi paramsParam1Param1 = null;

    static String paramsParam1Param2Param1 = "LfyV.uDIAz";

    static double paramsParam1Param2Param2 = 0.3638791279637503;

    static String paramsParam1Param2Param3 = "['G3._REL5";

    static Provider paramsParam1Param2 = new AuthProvider(paramsParam1Param2Param1, paramsParam1Param2Param2, paramsParam1Param2Param3);

    static String paramsParam1Param3 = "u J<=O#=&4";

    static KeyStore paramsParam1 = new KeyStore(paramsParam1Param1, paramsParam1Param2, paramsParam1Param3);

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
        System.out.println(new MyJVMTest_14713().buildCertPath(cpb, params));
    }
}
