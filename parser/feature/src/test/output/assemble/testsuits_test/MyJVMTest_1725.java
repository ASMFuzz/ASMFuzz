import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_1725 {

    static String dfParam1 = " ;),\"y[WWy";

    static DecimalFormat df = new DecimalFormat(dfParam1);

    static String s = "K\\vCXq6\"dR";

    static int multiplier = 1;

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
        new MyJVMTest_1725().test(df, s, multiplier);
    }
}
