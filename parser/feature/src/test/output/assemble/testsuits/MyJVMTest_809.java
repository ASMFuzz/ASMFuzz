import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_809 {

    static int valParam1 = 972;

    static Random valParam2 = new Random();

    static BigInteger val = new BigInteger(valParam1, valParam2);

    static int modParam1 = 919;

    static Random modParam2 = new Random();

    static BigInteger mod = new BigInteger(modParam1, modParam2);

    static String invParam1 = "HO`.hxQP)j";

    static int invParam2 = 526;

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
        new MyJVMTest_809().check(val, mod, inv);
    }
}
