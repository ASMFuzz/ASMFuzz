import java.math.*;
import java.util.*;

public class MyJVMTest_14812 {

    static double aParam1 = Double.NEGATIVE_INFINITY;

    static String aParam2Param1 = "_OB@wVoq\"Q";

    static MathContext aParam2 = new MathContext(aParam2Param1);

    static BigDecimal a = new BigDecimal(aParam1, aParam2);

    static long bParam1 = 9223372036854775807L;

    static int bParam2Param1 = 490;

    static MathContext bParam2 = new MathContext(bParam2Param1);

    static BigDecimal b = new BigDecimal(bParam1, bParam2);

    static int expected = -1795541301;

    static String prefix = "PrY8Myql@\"";

    int compareNumerically(BigDecimal a, BigDecimal b, int expected, String prefix) {
        int result = a.compareTo(b);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println("Testing " + prefix + "(" + a + ").compareTo(" + b + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14812().compareNumerically(a, b, expected, prefix));
    }
}
