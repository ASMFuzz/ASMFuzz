import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_13586 {

    static String text = ">W~m@4$kiE";

    static int expectedParam1Param1 = 263;

    static int expectedParam1Param2 = 741;

    static Random expectedParam1Param3 = new Random();

    static BigInteger expectedParam1 = new BigInteger(expectedParam1Param1, expectedParam1Param2, expectedParam1Param3);

    static BigDecimal expected = new BigDecimal(expectedParam1);

    static DecimalFormat df = null;

    static boolean err = false;

    BigDecimal checkParse(String text, BigDecimal expected) {
        BigDecimal got = (BigDecimal) df.parse(text, new ParsePosition(0));
        if (!got.equals(expected)) {
            err = true;
            System.err.println("    DecimalFormat parse(BigDecimal) error:" + "\n\ttext:       " + text + "\n\tpattern:    " + df.toPattern() + "\n\tmultiplier: " + df.getMultiplier() + "\n\tgot:        " + got + "\n\texpected:   " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13586().checkParse(text, expected);
    }
}
