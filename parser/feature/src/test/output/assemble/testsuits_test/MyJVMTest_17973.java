import java.math.*;
import java.util.*;

public class MyJVMTest_17973 {

    static long aParam1 = 9223372036854775807L;

    static int aParam2Param1 = 826;

    static MathContext aParam2 = new MathContext(aParam2Param1);

    static BigDecimal a = new BigDecimal(aParam1, aParam2);

    static double bParam1 = Double.POSITIVE_INFINITY;

    static BigDecimal b = new BigDecimal(bParam1);

    static boolean expected = false;

    static String prefix = "ARt\\ht##xb";

    int compare(BigDecimal a, BigDecimal b, boolean expected, String prefix) {
        boolean result = a.equals(b);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println("Testing " + prefix + "(" + a + ").compareTo(" + b + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17973().compare(a, b, expected, prefix));
    }
}
