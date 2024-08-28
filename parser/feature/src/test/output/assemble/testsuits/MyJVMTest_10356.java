import static java.lang.Math.*;
import java.security.SecureRandom;
import java.security.Provider;
import java.security.AuthProvider;

public class MyJVMTest_10356 {

    static SecureRandomSpi srParam1 = null;

    static String srParam2Param1 = "MYdMuwf*4+";

    static double srParam2Param2 = 0.7303640403949158;

    static String srParam2Param3 = "HOBbMM*Ga'";

    static Provider srParam2 = new AuthProvider(srParam2Param1, srParam2Param2, srParam2Param3);

    static SecureRandom sr = new SecureRandom(srParam1, srParam2);

    boolean forEachSeedBytes(SecureRandom sr) {
        boolean success = true;
        sr.setSeed(1l);
        for (int seedByte : new int[] { Integer.MIN_VALUE, -1, 0, 1, 256, 1024, Short.MAX_VALUE, (int) pow(2, 20) }) {
            try {
                byte[] seed = sr.generateSeed(seedByte);
                if (seed.length != seedByte) {
                    throw new RuntimeException("Not able to produce expected " + "seed size.");
                }
            } catch (IllegalArgumentException e) {
                if (seedByte >= 0) {
                    throw new RuntimeException("Unknown Exception occured.", e);
                }
                System.out.printf("%nPASS - Exception expected when required " + "seed size requested is negative: %s", seedByte);
            }
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10356().forEachSeedBytes(sr));
    }
}
