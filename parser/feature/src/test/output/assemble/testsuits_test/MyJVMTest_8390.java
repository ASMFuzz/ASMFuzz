import java.math.*;
import java.util.*;

public class MyJVMTest_8390 {

    static char[] aParam1 = { 'P', '*', '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static int aParam2 = 698;

    static int aParam3 = 237;

    static BigDecimal a = new BigDecimal(aParam1, aParam2, aParam3);

    static char[] bParam1 = { 'B', Character.MAX_VALUE, '(', '9', '0', '0', Character.MAX_VALUE, '0', '9', 'P' };

    static int bParam2Param1 = 750;

    static RoundingMode bParam2Param2 = null;

    static MathContext bParam2 = new MathContext(bParam2Param1, bParam2Param2);

    static BigDecimal b = new BigDecimal(bParam1, bParam2);

    static boolean expected = false;

    static String prefix = "i:yG,Ral.L";

    int compare(BigDecimal a, BigDecimal b, boolean expected, String prefix) {
        boolean result = a.equals(b);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println("Testing " + prefix + "(" + a + ").compareTo(" + b + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8390().compare(a, b, expected, prefix));
    }
}
