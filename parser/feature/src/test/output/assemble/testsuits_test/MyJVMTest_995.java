import java.text.*;
import java.util.*;

public class MyJVMTest_995 {

    static String nfParam1 = "9Pd#jD/CWA";

    static NumberFormat nf = new ChoiceFormat(nfParam1);

    static String given = "=~C:UJeqpT";

    static Number expected = null;

    static String locale = ".`Y;)[.N,;";

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
        new MyJVMTest_995().testNumberFormatParsing(nf, given, expected, locale);
    }
}
