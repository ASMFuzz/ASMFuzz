import static java.awt.font.NumericShaper.*;
import java.awt.font.NumericShaper;

public class MyJVMTest_16345 {

    static String ranges = "O4tt'$|cIX";

    static NumericShaper ns = null;

    static String given = "i[myx>4*n7";

    static String expected = "OLBV=UK.vy";

    static boolean err = false;

    String checkResult(String ranges, NumericShaper ns, String given, String expected) {
        char[] text = given.toCharArray();
        ns.shape(text, 0, text.length);
        String got = new String(text);
        if (!expected.equals(got)) {
            err = true;
            System.err.println("Error with range(s) <" + ranges + ">.");
            System.err.println("  text     = " + given);
            System.err.println("  got      = " + got);
            System.err.println("  expected = " + expected);
        } else {
            System.out.println("OK with range(s) <" + ranges + ">.");
            System.out.println("  text     = " + given);
            System.out.println("  got      = " + got);
            System.out.println("  expected = " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16345().checkResult(ranges, ns, given, expected);
    }
}
