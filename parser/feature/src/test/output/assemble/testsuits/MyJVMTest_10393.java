import javax.net.ssl.*;

public class MyJVMTest_10393 {

    static String[] ciphers = { "us^<2>s^@s", "C0nZ}d'4]K", "nG|mi)5KQ_", ">\"<RUvKIqB", "rvHicP<{Kn", "HBYz<UvsKr", "ud7oy4d_j^", "3OJzc8-q t", "9C+vh=)K1)", "k99pPV.Rq:" };

    static String enabledCipherSuite = "ZSaB&Kn?'r";

    static String notEnabledCipherSuite = "{7T(D, =%U";

    String checkSupportedCiphers(String[] ciphers) throws Exception {
        if (ciphers.length == 0) {
            throw new Exception("No supported cipher suites");
        }
        boolean hasEnabledCipherSuite = enabledCipherSuite.isEmpty();
        boolean hasNotEnabledCipherSuite = notEnabledCipherSuite.isEmpty();
        for (String cipher : ciphers) {
            System.out.println("\tsupported cipher suite " + cipher);
            if (!enabledCipherSuite.isEmpty() && cipher.equals(enabledCipherSuite)) {
                hasEnabledCipherSuite = true;
            }
            if (!notEnabledCipherSuite.isEmpty() && cipher.equals(notEnabledCipherSuite)) {
                hasNotEnabledCipherSuite = true;
            }
        }
        if (!hasEnabledCipherSuite) {
            throw new Exception("Cipher suite " + enabledCipherSuite + " should be supported");
        }
        if (!hasNotEnabledCipherSuite) {
            throw new Exception("Cipher suite " + notEnabledCipherSuite + " should not be enabled");
        }
        return cipher;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10393().checkSupportedCiphers(ciphers);
    }
}
