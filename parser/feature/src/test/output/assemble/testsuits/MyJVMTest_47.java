import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_47 {

    static String text = "5U!gl4_[vI";

    static Long expected = -9223372036854775808L;

    static DecimalFormat df = null;

    static boolean err = false;

    Long checkParse(String text, Long expected) {
        Long got = (Long) df.parse(text, new ParsePosition(0));
        if (!got.equals(expected)) {
            err = true;
            System.err.println("    DecimalFormat parse(long) error:" + "\n\ttext:       " + text + "\n\tpattern:    " + df.toPattern() + "\n\tmultiplier: " + df.getMultiplier() + "\n\tgot:        " + got + "\n\texpected:   " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_47().checkParse(text, expected);
    }
}
