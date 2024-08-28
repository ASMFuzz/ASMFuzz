import java.math.*;

public class MyJVMTest_15632 {

    static long i = 0;

    static char[] bdParam1 = { Character.MIN_VALUE, Character.MIN_VALUE, '0', 'G', Character.MIN_VALUE, '\\', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int bdParam2 = 9;

    static int bdParam3 = 100;

    static String bdParam4Param1 = "<74/;Z //<";

    static MathContext bdParam4 = new MathContext(bdParam4Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2, bdParam3, bdParam4);

    long testDoubleValue0(long i, BigDecimal bd) {
        if (bd.doubleValue() != i || bd.longValue() != i)
            throw new RuntimeException("Unexpected equality failure for " + i + "\t" + bd);
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15632().testDoubleValue0(i, bd);
    }
}
