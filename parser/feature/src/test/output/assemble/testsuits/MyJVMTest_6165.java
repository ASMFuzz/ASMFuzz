import java.text.*;
import java.util.*;

public class MyJVMTest_6165 {

    static double[] nfParam1 = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0.3286399128323546, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, 0.44754881786241985, Double.NEGATIVE_INFINITY };

    static String[] nfParam2 = { "Ilx|G*YBbm", "!YkJUAD9s\\", "NY iM(mU>Q", "A2m|#wUi%;", "Q9&f@\\tpe>", "}NecZ*C?vi", "V+9R:\"!IVz", "-7d~:ob+>g", "|@k08/H^Wn", "LD?Ibxaq1P" };

    static NumberFormat nf = new ChoiceFormat(nfParam1, nfParam2);

    static String given = "MMc3XQZ]lB";

    static int expected = 0;

    static String locale = "k\"W<G;t$*[";

    static boolean err = false;

    static boolean verbose = false;

    String testNumberFormatParsingCheckException(NumberFormat nf, String given, int expected, String locale) {
        try {
            Number n = nf.parse(given);
            err = true;
            System.err.print("  Failed: NumberFormat(" + locale);
            System.err.println(").parse(\"" + given + "\")");
            System.err.println("      should have thrown ParseException");
        } catch (ParseException pe) {
            int errorOffset = pe.getErrorOffset();
            if (errorOffset == expected) {
                if (verbose) {
                    System.out.print("  Passed: NumberFormat(" + locale);
                    System.out.println(").parse(\"" + given + "\")");
                    System.out.print("      threw ParseException as expected, and its errorOffset was correct: ");
                    System.out.println(errorOffset);
                }
            } else {
                err = true;
                System.err.print("  Failed: NumberFormat(" + locale);
                System.err.println(").parse(\"" + given + "\")");
                System.err.print("      threw ParseException as expected, but its errorOffset was incorrect: ");
                System.err.println(errorOffset);
            }
        }
        return given;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6165().testNumberFormatParsingCheckException(nf, given, expected, locale);
    }
}
