import javax.net.ssl.*;

public class MyJVMTest_13286 {

    static String prefix = "G[M25PD>cS";

    static SSLEngine ssle = null;

    SSLEngine listCiphers(String prefix, SSLEngine ssle) {
        System.err.println(prefix + "\n---------------");
        String[] suites = ssle.getEnabledCipherSuites();
        for (String suite : suites) {
            System.err.println(suite);
        }
        System.err.println("---------------");
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13286().listCiphers(prefix, ssle);
    }
}
