import java.text.*;
import java.util.*;

public class MyJVMTest_7457 {

    static double[] f1Param1 = { 0.3908779453324236, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, 0d, 0d, 0d, Double.MAX_VALUE };

    static String[] f1Param2 = { "V>-<#;:1*w", " 0}!(VLEo6", "^$=J$n{\"*R", "{iF:F<bO$x", "^Zul%t}D=#", "Y\\D}2Gsm9l", "xy-|AS+[jp", ":m\\\"DM`CJ4", "0&I~cr;bQN", "<\\J0$0/g+~" };

    static ChoiceFormat f1 = new ChoiceFormat(f1Param1, f1Param2);

    static String f2Param1 = "4<OdZj<fEa";

    static ChoiceFormat f2 = new ChoiceFormat(f2Param1);

    static boolean expected = true;

    boolean check(ChoiceFormat f1, ChoiceFormat f2, boolean expected) {
        boolean got = f1.equals(f2);
        if (got != expected) {
            throw new RuntimeException("Test failed for ChoiceFormat.equals(). Got: " + got + ", Expected: " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7457().check(f1, f2, expected);
    }
}
