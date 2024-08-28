import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_9988 {

    static String valParam1 = "z{g&/2'JM8";

    static int valParam2 = 490;

    static BigInteger val = new BigInteger(valParam1, valParam2);

    static int modParam1 = 540;

    static long modParam2Param1 = -9223372036854775808L;

    static Random modParam2 = new Random(modParam2Param1);

    static BigInteger mod = new BigInteger(modParam1, modParam2);

    static int invParam1 = 585;

    static long invParam2Param1 = 9223372036854775807L;

    static Random invParam2 = new Random(invParam2Param1);

    static BigInteger inv = new BigInteger(invParam1, invParam2);

    BigInteger check(BigInteger val, BigInteger mod, BigInteger inv) {
        BigInteger r = inv.multiply(val).remainder(mod);
        if (r.signum() == -1)
            r = r.add(mod);
        if (!r.equals(BigInteger.ONE))
            throw new RuntimeException("Numerically incorrect modular inverse");
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9988().check(val, mod, inv);
    }
}
