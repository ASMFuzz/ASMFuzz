import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Random;

public class MyJVMTest_4183 {

    static int biParam1 = 505;

    static Random biParam2 = new Random();

    static BigInteger bi = new BigInteger(biParam1, biParam2);

    static int scale = 2;

    static int mcParam1 = 893;

    static MathContext mc = new MathContext(mcParam1);

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
        System.out.println(new MyJVMTest_4183().testRoundingFromBigInteger(bi, scale, mc));
    }
}
