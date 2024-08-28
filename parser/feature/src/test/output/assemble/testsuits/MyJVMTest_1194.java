import javax.net.ssl.*;

public class MyJVMTest_1194 {

    static String[] ciphers = { "]&G\\H?\\o3 ", "l?J*^4C%x>", "7?h@D81a@3", "/TokZ&'~(c", "UA$DM=3@Pi", "@`|%9iUnh`", "PY4Yx}\\44~", "$_PO .pvz6", "N1|]bFSm![", " eDsz+#2jb" };

    static String enabledCipherSuite = "m>()>uBd!:";

    static String notEnabledCipherSuite = ".:u.|Yl=T~";

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
        new MyJVMTest_1194().checkSupportedCiphers(ciphers);
    }
}
