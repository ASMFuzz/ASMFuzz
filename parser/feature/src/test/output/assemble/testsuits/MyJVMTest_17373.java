import java.security.*;
import java.util.*;

public class MyJVMTest_17373 {

    static SecureRandomSpi srParam1 = null;

    static String srParam2Param1 = "r&-5=SE\"`X";

    static double srParam2Param2 = Double.NEGATIVE_INFINITY;

    static String srParam2Param3 = "|qO``/#h4Q";

    static Provider srParam2 = new AuthProvider(srParam2Param1, srParam2Param2, srParam2Param3);

    static SecureRandom sr = new SecureRandom(srParam1, srParam2);

    static String os = System.getProperty("os.name", "unknown");

    SecureRandom handleLinuxRead(SecureRandom sr) throws Exception {
        if (os.equals("Linux")) {
            if (!sr.getAlgorithm().equalsIgnoreCase("NativePRNGBlocking")) {
                sr.nextBytes(new byte[34]);
            }
        } else {
            sr.nextBytes(new byte[34]);
            sr.generateSeed(34);
            sr.setSeed(new byte[34]);
        }
        return sr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17373().handleLinuxRead(sr);
    }
}
