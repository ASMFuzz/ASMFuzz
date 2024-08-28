import javax.net.ssl.*;

public class MyJVMTest_17923 {

    static String[] ciphers = { "xq$,'UeWXh", "jHWTE;b%<I", "1#^VB3e~g#", ">y?C>,we$-", "QX,W6R0q:x", "}ls}in66Vy", "X(Rzrs[vCg", "j\"cr(mp# S", "v,Q2L1BS;%", "0IcWMLXG\"p" };

    static String enabledCipherSuite = "p_F-WI:JW|";

    static String notEnabledCipherSuite = "ja.m/cwh<p";

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
        new MyJVMTest_17923().checkEnabledCiphers(ciphers);
    }
}
