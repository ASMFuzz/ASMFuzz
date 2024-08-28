import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_4222 {

    static String text = "-,&%=)Z@IV";

    static String expectedParam1Param1 = "8Lx+Eg TYf";

    static BigInteger expectedParam1 = new BigInteger(expectedParam1Param1);

    static int expectedParam2 = 398;

    static String expectedParam3Param1 = "l[R5*P\"^O4";

    static MathContext expectedParam3 = new MathContext(expectedParam3Param1);

    static BigDecimal expected = new BigDecimal(expectedParam1, expectedParam2, expectedParam3);

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
        new MyJVMTest_4222().checkParse(text, expected);
    }
}
