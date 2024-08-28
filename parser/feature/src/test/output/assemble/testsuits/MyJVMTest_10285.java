import java.net.*;
import java.security.*;
import java.security.cert.*;
import java.security.spec.*;
import javax.net.ssl.*;

public class MyJVMTest_10285 {

    static KeyManagerFactorySpi kmfParam1 = null;

    static String kmfParam2Param1 = "Z%omIf|Sh|";

    static double kmfParam2Param2 = Double.MAX_VALUE;

    static String kmfParam2Param3 = "mv'b$73z(-";

    static Provider kmfParam2 = new AuthProvider(kmfParam2Param1, kmfParam2Param2, kmfParam2Param3);

    static String kmfParam3 = "x7!+4B:v+U";

    static KeyManagerFactory kmf = new KeyManagerFactory(kmfParam1, kmfParam2, kmfParam3);

    static TrustManagerFactorySpi tmfParam1 = null;

    static String tmfParam2Param1 = "&3P~$tXyD`";

    static double tmfParam2Param2 = Double.NEGATIVE_INFINITY;

    static String tmfParam2Param3 = "$SV;F{lf`G";

    static Provider tmfParam2 = new AuthProvider(tmfParam2Param1, tmfParam2Param2, tmfParam2Param3);

    static String tmfParam3 = "RS<gteChR+";

    static TrustManagerFactory tmf = new TrustManagerFactory(tmfParam1, tmfParam2, tmfParam3);

    static ManagerFactoryParameters mfp = null;

    ManagerFactoryParameters doit(KeyManagerFactory kmf, TrustManagerFactory tmf, ManagerFactoryParameters mfp) throws Exception {
        kmf.init(mfp);
        tmf.init(mfp);
        return mfp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10285().doit(kmf, tmf, mfp);
    }
}
