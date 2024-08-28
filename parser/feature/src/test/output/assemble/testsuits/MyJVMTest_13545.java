import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MyJVMTest_13545 {

    static String biParam1 = "}qd~UwT1rf";

    static int biParam2 = 52;

    static BigInteger bi = new BigInteger(biParam1, biParam2);

    static int scale = 0;

    static int mcParam1 = 377;

    static RoundingMode mcParam2 = null;

    static MathContext mc = new MathContext(mcParam1, mcParam2);

    int testRoundingFromBigInteger(BigInteger bi, int scale, MathContext mc) {
        int failures = 0;
        BigDecimal bd1 = new BigDecimal(bi, scale, mc);
        BigDecimal bd2 = (new BigDecimal(bi, scale)).round(mc);
        if (!bd1.equals(bd2)) {
            System.out.println("new BigDecimal(BigInteger,int,MathContext):" + "BigInteger == " + bi + ";  scale == " + scale + "; result == " + bd1 + "; expected  == " + bd2);
            failures++;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13545().testRoundingFromBigInteger(bi, scale, mc));
    }
}
