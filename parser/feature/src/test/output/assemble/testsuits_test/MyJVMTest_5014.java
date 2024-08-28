import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_5014 {

    static SSLContextSpi ctxParam1 = null;

    static String ctxParam2Param1 = "Zerbt212]#";

    static double ctxParam2Param2 = 0d;

    static String ctxParam2Param3 = "QS,ikeFx\"R";

    static Provider ctxParam2 = new AuthProvider(ctxParam2Param1, ctxParam2Param2, ctxParam2Param3);

    static String ctxParam3 = "A9gDLB;W!D";

    static SSLContext ctx = new SSLContext(ctxParam1, ctxParam2, ctxParam3);

    static KeyManagerFactorySpi kmfParam1 = null;

    static String kmfParam2Param1 = "VQ2FIQP&^W";

    static double kmfParam2Param2 = Double.MAX_VALUE;

    static String kmfParam2Param3 = "j34c9QA:?L";

    static Provider kmfParam2 = new AuthProvider(kmfParam2Param1, kmfParam2Param2, kmfParam2Param3);

    static String kmfParam3 = "H6EY=Io@%)";

    static KeyManagerFactory kmf = new KeyManagerFactory(kmfParam1, kmfParam2, kmfParam3);

    static TrustManagerFactorySpi tmfParam1 = null;

    static String tmfParam2Param1 = "x0b]RTZGHw";

    static double tmfParam2Param2 = Double.POSITIVE_INFINITY;

    static String tmfParam2Param3 = "S|U!ry6%F\\";

    static Provider tmfParam2 = new AuthProvider(tmfParam2Param1, tmfParam2Param2, tmfParam2Param3);

    static String tmfParam3 = "1[?yItfT7_";

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
        System.out.println(new MyJVMTest_5014().makeEngine(ctx, kmf, tmf, isClient));
    }
}
