import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_11767 {

    static String i1Param1 = "DA0pprh0UU";

    static BigInteger i1 = new BigInteger(i1Param1);

    static int i2Param1 = 362;

    static Random i2Param2 = new Random();

    static BigInteger i2 = new BigInteger(i2Param1, i2Param2);

    BigInteger m(BigInteger i1, BigInteger i2) {
        BigInteger res = BigInteger.valueOf(0);
        for (int i = 0; i < 100; i++) {
            res.add(i1.multiply(i2));
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11767().m(i1, i2));
    }
}
