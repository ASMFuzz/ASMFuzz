import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_8209 {

    static String lParam1Param1 = "n,udKLsPg[";

    static BigInteger lParam1 = new BigInteger(lParam1Param1);

    static String lParam2Param1 = "/:sb5*Kv5Q";

    static MathContext lParam2 = new MathContext(lParam2Param1);

    static BigDecimal l = new BigDecimal(lParam1, lParam2);

    static String rParam1 = "6\\\\,49>B=7";

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
        System.out.println(new MyJVMTest_8209().equalsTest(l, r, expected));
    }
}
