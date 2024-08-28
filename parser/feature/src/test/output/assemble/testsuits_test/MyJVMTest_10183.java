import java.text.*;
import java.util.*;

public class MyJVMTest_10183 {

    static double[] nfParam1 = { Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, Double.NaN };

    static String[] nfParam2 = { "IERq7PPvjd", "TQuo?u'm<C", "f$EZjfNQ:6", "{XoppgJ?d$", "7p9|yP<s>m", "<<rVc\"S\\t{", ",5yRWm[SqL", "zwL6eN`DEN", "uTIR'>*:g}", "nDg@|NZ:W(" };

    static NumberFormat nf = new ChoiceFormat(nfParam1, nfParam2);

    static String given = "90\\\\mGwZ)M";

    static Number expected = null;

    static String locale = "FuX %]WFw.";

    static boolean err = false;

    static boolean verbose = false;

    String testNumberFormatParsing(NumberFormat nf, String given, Number expected, String locale) {
        try {
            Number n = nf.parse(given);
            if (n.equals(expected)) {
                if (verbose) {
                    System.out.print("  Passed: NumberFormat(" + locale);
                    System.out.println(").parse(\"" + given + "\")");
                    System.out.println("      ---> " + n);
                }
            } else {
                err = true;
                System.err.print("  Failed: Unexpected NumberFormat(" + locale);
                System.err.println(").parse(\"" + given + "\") result.");
                System.err.println("      Expected: " + expected);
                System.err.println("      Got:      " + n);
            }
        } catch (ParseException pe) {
            err = true;
            System.err.print("  Failed: Unexpected exception with NumberFormat(");
            System.err.println(locale + ").parse(\"" + given + "\") :");
            System.err.println("    " + pe);
        }
        return given;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10183().testNumberFormatParsing(nf, given, expected, locale);
    }
}
