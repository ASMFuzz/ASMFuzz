import java.math.*;

public class MyJVMTest_2209 {

    static long i = 9223372036854775807L;

    static double bdParam1 = Double.NEGATIVE_INFINITY;

    static String bdParam2Param1 = " (,?r3\\?'j";

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    long testFloatValue0(long i, BigDecimal bd) {
        if (bd.floatValue() != i || bd.longValue() != i)
            throw new RuntimeException("Unexpected equality failure for " + i + "\t" + bd);
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2209().testFloatValue0(i, bd);
    }
}
