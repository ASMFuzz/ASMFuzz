import javax.net.ssl.*;

public class MyJVMTest_3078 {

    static String[] ciphers = { "'/`jLuam4|", "F}*<**^|5>", "|6_d3F[alV", "RS~Ia$3<mX", "a@6rq Zk 7", "g'?jaPoZ4(", "0eeNpC,y5N", "&>;GgbZcXn", ",k#JPl^iSy", "k}buATv9\"x" };

    static String enabledCipherSuite = "[6'23BBaj>";

    static String disabledCipherSuite = "m'[bq/t+D4";

    String checkSupportedCiphers(String[] ciphers) throws Exception {
        if (ciphers.length == 0) {
            throw new Exception("No supported cipher suites");
        }
        boolean hasEnabledCipherSuite = enabledCipherSuite.isEmpty();
        boolean hasDisabledCipherSuite = disabledCipherSuite.isEmpty();
        for (String cipher : ciphers) {
            System.out.println("\tsupported cipher suite " + cipher);
            if (!enabledCipherSuite.isEmpty() && cipher.equals(enabledCipherSuite)) {
                hasEnabledCipherSuite = true;
            }
            if (!disabledCipherSuite.isEmpty() && cipher.equals(disabledCipherSuite)) {
                hasDisabledCipherSuite = true;
            }
        }
        if (!hasEnabledCipherSuite) {
            throw new Exception("Cipher suite " + enabledCipherSuite + " should be supported");
        }
        if (!hasDisabledCipherSuite) {
            throw new Exception("Cipher suite " + disabledCipherSuite + " should be supported");
        }
        return cipher;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3078().checkSupportedCiphers(ciphers);
    }
}
