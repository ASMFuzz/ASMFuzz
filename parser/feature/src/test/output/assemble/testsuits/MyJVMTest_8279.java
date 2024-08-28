import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_8279 {

    static String text = ">`u*=cLvV-";

    static Double expected = Double.MAX_VALUE;

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
        new MyJVMTest_8279().checkParse(text, expected);
    }
}
