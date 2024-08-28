import javax.net.ssl.*;

public class MyJVMTest_8250 {

    static String[] ciphers = { "`>A -;[J+\\", "z.ln_Ok*\\b", "~J#h>{>MGS", "OO|#Nc\\5/o", "RA-U`QFZUD", "c7oW@s5@c&", "y?ffr}{tA8", "$'vIGqbtXr", "!8`hDSuH/@", "O>{c$B81RZ" };

    static String enabledCipherSuite = "w>]f:8eh7d";

    static String disabledCipherSuite = "Isk/D7JUFq";

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
        new MyJVMTest_8250().checkEnabledCiphers(ciphers);
    }
}
