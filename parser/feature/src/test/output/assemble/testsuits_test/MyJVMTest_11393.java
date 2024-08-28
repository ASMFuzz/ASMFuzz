import java.security.cert.*;
import java.util.HashSet;

public class MyJVMTest_11393 {

    static CertPath cp = null;

    static Set<TrustAnchor> paramsParam1 = new HashSet<TrustAnchor>();

    static PKIXParameters params = new PKIXParameters(paramsParam1);

    CertPath validateCertPath(CertPath cp, PKIXParameters params) throws Exception {
        CertPathValidator cpv = CertPathValidator.getInstance("PKIX");
        CertPathValidatorResult cpvr = cpv.validate(cp, params);
        return cp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11393().validateCertPath(cp, params);
    }
}
