import java.math.*;

public class MyJVMTest_11462 {

    static long i = 0;

    static long bdParam1 = 0;

    static BigDecimal bd = new BigDecimal(bdParam1);

    long testFloatValue0(long i, BigDecimal bd) {
        if (bd.floatValue() != i || bd.longValue() != i)
            throw new RuntimeException("Unexpected equality failure for " + i + "\t" + bd);
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11462().testFloatValue0(i, bd);
    }
}
