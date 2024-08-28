import java.math.*;

public class MyJVMTest_13744 {

    void testDoubleValue0(long i, BigDecimal bd) {
        if (bd.doubleValue() != i || bd.longValue() != i)
            throw new RuntimeException("Unexpected equality failure for " + i + "\t" + bd);
    }

    void testFloatValue0(long i, BigDecimal bd) {
        if (bd.floatValue() != i || bd.longValue() != i)
            throw new RuntimeException("Unexpected equality failure for " + i + "\t" + bd);
    }

    static long two2the24 = 1L << 23;

    static long maxFltLong = (long) (Integer.MAX_VALUE & ~(0xff));

    void testFloatDoubleValue() {
        long[] longValues = { Long.MIN_VALUE, 0, 1, 2, two2the24 - 1, two2the24, two2the24 + 1, maxFltLong - 1, maxFltLong, maxFltLong + 1 };
        for (long i : longValues) {
            BigDecimal bd1 = new BigDecimal(i);
            BigDecimal bd2 = new BigDecimal(-i);
            testDoubleValue0(i, bd1);
            testDoubleValue0(-i, bd2);
            testFloatValue0(i, bd1);
            testFloatValue0(-i, bd2);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13744().testFloatDoubleValue();
    }
}
