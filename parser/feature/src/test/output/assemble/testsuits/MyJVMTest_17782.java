import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_17782 {

    static int lParam1 = 604;

    static String lParam2Param1 = "RGf]GGZ8Ce";

    static MathContext lParam2 = new MathContext(lParam2Param1);

    static BigDecimal l = new BigDecimal(lParam1, lParam2);

    static char[] rParam1 = { Character.MAX_VALUE, 'M', '(', 'G', Character.MAX_VALUE, '0', 'b', ';', Character.MIN_VALUE, 'w' };

    static BigDecimal r = new BigDecimal(rParam1);

    static boolean expected = true;

    int equalsTest(BigDecimal l, BigDecimal r, boolean expected) {
        boolean result = l.equals(r);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println(l + " .equals(" + r + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17782().equalsTest(l, r, expected));
    }
}
