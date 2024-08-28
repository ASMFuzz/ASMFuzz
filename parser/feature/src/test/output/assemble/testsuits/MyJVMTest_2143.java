import java.security.cert.*;
import java.security.Provider;
import java.security.AuthProvider;
import java.security.KeyStore;

public class MyJVMTest_2143 {

    static CertPath cp = null;

    static KeyStoreSpi paramsParam1Param1 = null;

    static String paramsParam1Param2Param1 = "meY`|=&$]i";

    static double paramsParam1Param2Param2 = Double.NEGATIVE_INFINITY;

    static String paramsParam1Param2Param3 = "_(6<vw&M4^";

    static Provider paramsParam1Param2 = new AuthProvider(paramsParam1Param2Param1, paramsParam1Param2Param2, paramsParam1Param2Param3);

    static String paramsParam1Param3 = "]id_r5yNhj";

    static KeyStore paramsParam1 = new KeyStore(paramsParam1Param1, paramsParam1Param2, paramsParam1Param3);

    static PKIXParameters params = new PKIXParameters(paramsParam1);

    CertPath validateCertPath(CertPath cp, PKIXParameters params) throws Exception {
        CertPathValidator cpv = CertPathValidator.getInstance("PKIX");
        CertPathValidatorResult cpvr = cpv.validate(cp, params);
        return cp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2143().validateCertPath(cp, params);
    }
}
