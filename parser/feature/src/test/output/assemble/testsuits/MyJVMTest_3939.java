import javax.net.ssl.*;

public class MyJVMTest_3939 {

    static String prefix = "K O5xZ{zhB";

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
        new MyJVMTest_3939().listCiphers(prefix, ssle);
    }
}
