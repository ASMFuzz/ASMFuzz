import java.math.*;
import java.util.*;

public class MyJVMTest_5387 {

    static int aParam1Param1 = 781;

    static int aParam1Param2 = 57;

    static Random aParam1Param3 = new Random();

    static BigInteger aParam1 = new BigInteger(aParam1Param1, aParam1Param2, aParam1Param3);

    static BigDecimal a = new BigDecimal(aParam1);

    static String bParam1 = "N9%@`*!gme";

    static BigDecimal b = new BigDecimal(bParam1);

    static int expected = 3;

    static String prefix = ">X1gcGJ=Fe";

    int compareNumerically(BigDecimal a, BigDecimal b, int expected, String prefix) {
        int result = a.compareTo(b);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println("Testing " + prefix + "(" + a + ").compareTo(" + b + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5387().compareNumerically(a, b, expected, prefix));
    }
}
