import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_14423 {

    static SSLContextSpi ctxParam1 = null;

    static String ctxParam2Param1 = "aMZ0updUc,";

    static double ctxParam2Param2 = Double.MAX_VALUE;

    static String ctxParam2Param3 = ":|>?CE+`yg";

    static Provider ctxParam2 = new AuthProvider(ctxParam2Param1, ctxParam2Param2, ctxParam2Param3);

    static String ctxParam3 = "_h4ZIYPO<c";

    static SSLContext ctx = new SSLContext(ctxParam1, ctxParam2, ctxParam3);

    static KeyManagerFactorySpi kmfParam1 = null;

    static String kmfParam2Param1 = "}h>V`.K]%7";

    static double kmfParam2Param2 = 0.8147924708926916;

    static String kmfParam2Param3 = "7v|mCW;z9X";

    static Provider kmfParam2 = new AuthProvider(kmfParam2Param1, kmfParam2Param2, kmfParam2Param3);

    static String kmfParam3 = "R>vgzDE>_N";

    static KeyManagerFactory kmf = new KeyManagerFactory(kmfParam1, kmfParam2, kmfParam3);

    static TrustManagerFactorySpi tmfParam1 = null;

    static String tmfParam2Param1 = "4|PXP&es={";

    static double tmfParam2Param2 = Double.NEGATIVE_INFINITY;

    static String tmfParam2Param3 = "AlVZ\\-g*1[";

    static Provider tmfParam2 = new AuthProvider(tmfParam2Param1, tmfParam2Param2, tmfParam2Param3);

    static String tmfParam3 = "PM_Mv}YktO";

    static TrustManagerFactory tmf = new TrustManagerFactory(tmfParam1, tmfParam2, tmfParam3);

    static boolean isClient = false;

    SSLEngine makeEngine(SSLContext ctx, KeyManagerFactory kmf, TrustManagerFactory tmf, boolean isClient) throws GeneralSecurityException {
        ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        SSLEngine ssle = ctx.createSSLEngine("localhost", 8443);
        ssle.setUseClientMode(isClient);
        ssle.setNeedClientAuth(false);
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14423().makeEngine(ctx, kmf, tmf, isClient));
    }
}
