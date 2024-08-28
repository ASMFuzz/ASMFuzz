import static java.awt.font.NumericShaper.*;
import java.awt.font.NumericShaper;

public class MyJVMTest_12723 {

    static String data = "FK9;2cjCi:";

    static String expected = "2sC'\\8-mTy";

    static NumericShaper ns_old = null, ns_new = null;

    static boolean err = false;

    String test(String data, String expected) {
        char[] text = data.toCharArray();
        ns_old.shape(text, 0, text.length);
        String got = new String(text);
        if (!expected.equals(got)) {
            err = true;
            System.err.println("Error with traditional range.");
            System.err.println("  text = " + data);
            System.err.println("  got = " + got);
            System.err.println("  expected = " + expected);
        } else {
            System.err.println("OK with traditional range.");
            System.err.println("  text = " + data);
            System.err.println("  got = " + got);
            System.err.println("  expected = " + expected);
        }
        text = data.toCharArray();
        ns_new.shape(text, 0, text.length);
        got = new String(text);
        if (!expected.equals(got)) {
            err = true;
            System.err.println("Error with new Enum range.");
            System.err.println("  text = " + data);
            System.err.println("  got = " + got);
            System.err.println("  expected = " + expected);
        } else {
            System.err.println("OK with new Enum range.");
            System.err.println("  text = " + data);
            System.err.println("  got = " + got);
            System.err.println("  expected = " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12723().test(data, expected);
    }
}
