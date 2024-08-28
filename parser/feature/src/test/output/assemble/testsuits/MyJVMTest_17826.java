import javax.net.ssl.*;

public class MyJVMTest_17826 {

    static String[] ciphers = { "Y4bD9ig?h^", "cz s8\\r4_o", "Gn/(-.[ uF", "{5V*Y8jT!)", "x5k7Q nW#9", "aYd0W{kQ6C", ";=7MalI^et", "\\zm@,I&jg'", "ObJ.g%.#;U", "\\qtmx('U}J" };

    static String enabledCipherSuite = "kN1=6bPQ7d";

    static String disabledCipherSuite = "G>S|)CeZ?t";

    boolean checkEnabledCiphers(String[] ciphers) throws Exception {
        if (ciphers.length == 0) {
            throw new Exception("No default cipher suites");
        }
        boolean isMatch = false;
        if (enabledCipherSuite.isEmpty()) {
            isMatch = true;
        }
        boolean isBroken = false;
        for (String cipher : ciphers) {
            System.out.println("\tdefault cipher suite " + cipher);
            if (!enabledCipherSuite.isEmpty() && cipher.equals(enabledCipherSuite)) {
                isMatch = true;
            }
            if (!disabledCipherSuite.isEmpty() && cipher.equals(disabledCipherSuite)) {
                isBroken = true;
            }
        }
        if (!isMatch) {
            throw new Exception("Cipher suite " + enabledCipherSuite + " should be enabled");
        }
        if (isBroken) {
            throw new Exception("Cipher suite " + disabledCipherSuite + " should be disabled");
        }
        return isMatch;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17826().checkEnabledCiphers(ciphers);
    }
}
