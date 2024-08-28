import java.io.*;
import java.security.*;

public class MyJVMTest_3207 {

    static String s1 = "M~vJ$R8s5\"";

    static SecureRandomSpi srParam1 = null;

    static String srParam2Param1 = "^Qy;c\"CA,s";

    static double srParam2Param2 = 0d;

    static String srParam2Param3 = "~;zCxFAC,=";

    static Provider srParam2 = new AuthProvider(srParam2Param1, srParam2Param2, srParam2Param3);

    static SecureRandom sr = new SecureRandom(srParam1, srParam2);

    String check(String s1, SecureRandom sr) throws Exception {
        String s2 = sr.getAlgorithm();
        if (s1.equals(s2) == false) {
            throw new Exception("Expected " + s1 + ", got " + s2);
        }
        return s2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3207().check(s1, sr);
    }
}
