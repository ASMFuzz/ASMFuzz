import java.math.BigDecimal;

public class MyJVMTest_10363 {

    static String bdParam1 = "]X^8}x:m\"t";

    static BigDecimal bd = new BigDecimal(bdParam1);

    static Number expected = null;

    static long longValue = -9223372036854775808L;

    static boolean isInt = false;

    int simpleIntValue(BigDecimal bd) {
        return bd.toBigInteger().intValue();
    }

    long simpleLongValue(BigDecimal bd) {
        return bd.toBigInteger().longValue();
    }

    int reportError(BigDecimal bd, Number expected, long longValue, boolean isInt) {
        System.err.format("For %s, scale=%d, expected %d, actual %d, simple %d%n", bd.toString(), bd.scale(), (isInt ? (Integer) expected : (Long) expected), longValue, (isInt ? simpleIntValue(bd) : simpleLongValue(bd)));
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10363().reportError(bd, expected, longValue, isInt));
    }
}
