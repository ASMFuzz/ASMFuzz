import java.text.*;
import java.util.*;

public class MyJVMTest_15091 {

    static String nfParam1 = "B/#S!0`)e*";

    static NumberFormat nf = new ChoiceFormat(nfParam1);

    static int given = 9;

    static String expected = "~S/dkfnG~?";

    static String locale = "fV/9@|7E%<";

    static boolean err = false;

    static boolean verbose = false;

    int testNumberFormatFormatting(NumberFormat nf, int given, String expected, String locale) {
        String str = nf.format(given);
        if (expected.equals(str)) {
            if (verbose) {
                System.out.print("  Passed: NumberFormat(" + locale);
                System.out.println(").format(" + given + ")");
                System.out.println("      ---> \"" + str + "\"");
            }
        } else {
            err = true;
            System.err.print("  Failed: Unexpected NumberFormat(" + locale);
            System.err.println(").format(" + given + ") result.");
            System.err.println("      Expected: \"" + expected + "\"");
            System.err.println("      Got:      \"" + str + "\"");
        }
        return given;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15091().testNumberFormatFormatting(nf, given, expected, locale);
    }
}
