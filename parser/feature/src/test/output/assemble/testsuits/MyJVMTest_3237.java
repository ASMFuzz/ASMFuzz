import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_3237 {

    static Number num = null;

    static String expected = "gsm+c&]lwE";

    static DecimalFormat df = null;

    static boolean err = false;

    Number checkFormat(Number num, String expected) {
        String got = df.format(num);
        if (!got.equals(expected)) {
            err = true;
            System.err.println("    DecimalFormat format(" + num.getClass().getName() + ") error:" + "\n\tnumber:     " + num + "\n\tpattern:    " + df.toPattern() + "\n\tmultiplier: " + df.getMultiplier() + "\n\tgot:        " + got + "\n\texpected:   " + expected);
        }
        return num;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3237().checkFormat(num, expected);
    }
}
