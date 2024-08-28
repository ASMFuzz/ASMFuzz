import javax.net.ssl.*;

public class MyJVMTest_12389 {

    static String[] ciphers = { ")_gS:s$~<j", "XG]/^3G!Mw", "[LI50-)um6", "6}<IP2pl*j", "X+ZWE{w<Fe", "fUv3# $fx%", "4<v),=1aTY", "V?}t^!rI2y", "?_kM,JO\"\"I", "aWDJgE' E`" };

    static String enabledCipherSuite = "a$`b~aF-j#";

    static String disabledCipherSuite = "N?`,hD'_Y3";

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
        new MyJVMTest_12389().checkSupportedCiphers(ciphers);
    }
}
