import java.text.*;
import java.util.*;

public class MyJVMTest_15636 {

    static String nfParam1 = "Va8 ~%rIpr";

    static NumberFormat nf = new ChoiceFormat(nfParam1);

    static String given = "wU:Q-:cgK+";

    static int expected = 559960145;

    static String locale = "\\A?\"0F:=jy";

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
        new MyJVMTest_15636().testNumberFormatParsingCheckException(nf, given, expected, locale);
    }
}
