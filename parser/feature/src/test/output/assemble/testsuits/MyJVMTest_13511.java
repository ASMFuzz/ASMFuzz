import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_13511 {

    static Number got = null;

    static char[] expectedParam1 = { Character.MAX_VALUE, 'r', Character.MIN_VALUE, '#', 'w', Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', '[' };

    static int expectedParam2 = 290;

    static int expectedParam3 = 148;

    static String expectedParam4Param1 = "cC ht]I;M<";

    static MathContext expectedParam4 = new MathContext(expectedParam4Param1);

    static BigDecimal expected = new BigDecimal(expectedParam1, expectedParam2, expectedParam3, expectedParam4);

    static int multiplier = -1207658512;

    static boolean err = false;

    Number check(Number got, BigDecimal expected, int multiplier) {
        if (!got.equals(expected)) {
            err = true;
            System.err.println("Failed: got:" + got + ", expected: " + expected + ", multiplier=" + multiplier);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13511().check(got, expected, multiplier);
    }
}
