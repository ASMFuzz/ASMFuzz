import java.math.*;

public class MyJVMTest_6162 {

    static long i = 0;

    static int bdParam1 = 554;

    static String bdParam2Param1 = "q<F|tu[{,c";

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    long testDoubleValue0(long i, BigDecimal bd) {
        if (bd.doubleValue() != i || bd.longValue() != i)
            throw new RuntimeException("Unexpected equality failure for " + i + "\t" + bd);
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6162().testDoubleValue0(i, bd);
    }
}
