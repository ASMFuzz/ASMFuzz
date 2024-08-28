import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_17855 {

    static String text = "g!by@06(wv";

    static Double expected = Double.NEGATIVE_INFINITY;

    static DecimalFormat df = null;

    static boolean err = false;

    Double checkParse(String text, Double expected) {
        Double got = (Double) df.parse(text, new ParsePosition(0));
        if (!got.equals(expected)) {
            err = true;
            System.err.println("    DecimalFormat parse(double) error:" + "\n\ttext:       " + text + "\n\tpattern:    " + df.toPattern() + "\n\tmultiplier: " + df.getMultiplier() + "\n\tgot:        " + got + "\n\texpected:   " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17855().checkParse(text, expected);
    }
}
