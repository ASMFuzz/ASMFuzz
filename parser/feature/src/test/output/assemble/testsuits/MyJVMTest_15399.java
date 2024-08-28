import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_15399 {

    static Number num = null;

    static String expected = "ZCsWaaX;Wk";

    static DecimalFormat df = null;

    static boolean err = false;

    Number checkFormat(Number num, String expected) {
        String got = df.format(num);
        if (!got.equals(expected)) {
            err = true;
            System.err.println("    DecimalFormat format(" + num.getClass().getName() + ") error:" + "\n\tnumber:           " + num + "\n\tSeparatorShown? : " + df.isDecimalSeparatorAlwaysShown() + "\n\tgot:              " + got + "\n\texpected:         " + expected);
        }
        return num;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15399().checkFormat(num, expected);
    }
}
