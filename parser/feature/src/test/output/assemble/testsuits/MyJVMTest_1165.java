import java.math.BigDecimal;

public class MyJVMTest_1165 {

    static char[] bdParam1 = { Character.MAX_VALUE, '6', Character.MIN_VALUE, Character.MIN_VALUE, 'G', Character.MIN_VALUE, 'L', 'g', Character.MAX_VALUE, Character.MAX_VALUE };

    static BigDecimal bd = new BigDecimal(bdParam1);

    static Number expected = null;

    static long longValue = -193216980503249475L;

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
        System.out.println(new MyJVMTest_1165().reportError(bd, expected, longValue, isInt));
    }
}
