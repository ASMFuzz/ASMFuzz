import javax.net.ssl.*;

public class MyJVMTest_8343 {

    static String[] ciphers = { "Bx ca=g4qQ", "=ypdW(;7L]", "HZ@HJ=O$[.", "%3kl?\":zZ-", "noN3NNUZ>6", "TF_GjdA}46", "Gm&;a& G5I", "S2a}1~e(] ", "~vA0;f#nBp", "~<wwr-zS4V" };

    static String enabledCipherSuite = "i8/)$ML@\"(";

    static String notEnabledCipherSuite = "h:;)L_r3S2";

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
            if (!notEnabledCipherSuite.isEmpty() && cipher.equals(notEnabledCipherSuite)) {
                isBroken = true;
            }
        }
        if (!isMatch) {
            throw new Exception("Cipher suite " + enabledCipherSuite + " should be enabled");
        }
        if (isBroken) {
            throw new Exception("Cipher suite " + notEnabledCipherSuite + " should not be enabled");
        }
        return isMatch;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8343().checkEnabledCiphers(ciphers);
    }
}
