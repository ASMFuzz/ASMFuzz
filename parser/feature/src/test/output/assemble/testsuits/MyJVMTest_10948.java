import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_10948 {

    static DecimalFormat df = new DecimalFormat();

    static String s = "b^<3X|Lhib";

    static int multiplier = 919620680;

    void check(Number got, BigDecimal expected, int multiplier) {
        if (!got.equals(expected)) {
            err = true;
            System.err.println("Failed: got:" + got + ", expected: " + expected + ", multiplier=" + multiplier);
        }
    }

    static boolean err = false;

    BigDecimal test(DecimalFormat df, String s, int multiplier) {
        df.setMultiplier(multiplier);
        Number num = null;
        try {
            num = df.parse(s);
        } catch (ParseException e) {
            err = true;
            System.err.println("Failed: Exception occurred: " + e.getMessage());
            return;
        }
        BigDecimal bd = new BigDecimal(s);
        try {
            bd = bd.divide(new BigDecimal(multiplier));
        } catch (ArithmeticException e) {
            bd = bd.divide(new BigDecimal(multiplier), RoundingMode.HALF_EVEN);
        }
        check(num, bd, multiplier);
        return bd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10948().test(df, s, multiplier);
    }
}
