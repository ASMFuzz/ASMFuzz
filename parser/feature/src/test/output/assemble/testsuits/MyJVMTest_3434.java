import java.text.*;
import java.util.*;

public class MyJVMTest_3434 {

    static SimpleDateFormat sdf = new SimpleDateFormat();

    static String pattern = "PlId1\\Z?I\"";

    static String given = "!XKgO/\\3h}";

    static int expectedGCParam1 = 874;

    static int expectedGCParam2 = 487;

    static int expectedGCParam3 = 774;

    static int expectedGCParam4 = 680;

    static int expectedGCParam5 = 389;

    static GregorianCalendar expectedGC = new GregorianCalendar(expectedGCParam1, expectedGCParam2, expectedGCParam3, expectedGCParam4, expectedGCParam5);

    static String locale = "qL\\>(cIiR5";

    static boolean err = false;

    static boolean verbose = false;

    String testDateFormatParsing(SimpleDateFormat sdf, String pattern, String given, GregorianCalendar expectedGC, String locale) {
        try {
            Date d = sdf.parse(given);
            if (expectedGC == null) {
                err = true;
                System.err.print("  Failed: SimpleDateFormat(" + locale);
                System.err.print(", \"" + pattern + "\").parse(\"" + given);
                System.err.println("\") should have thrown ParseException");
            } else if (expectedGC.getTime().equals(d)) {
                if (verbose) {
                    System.out.print("  Passed: SimpleDateFormat(" + locale);
                    System.out.print(", \"" + pattern + "\").parse(\"" + given);
                    System.out.println("\")");
                    System.out.print("      ---> " + d + " (" + d.getTime());
                    System.out.println(")");
                }
            } else {
                err = true;
                System.err.print("  Failed: SimpleDateFormat(" + locale);
                System.err.print(", \"" + pattern + "\").parse(\"" + given);
                System.err.println("\")");
                System.err.print("      Expected: " + expectedGC.getTime());
                System.err.println(" (" + d.getTime() + ")");
                System.err.print("      Got:      " + d + " (" + d.getTime());
                System.err.println(")");
                System.err.print("      Pattern:  \"");
                System.err.print(((DecimalFormat) sdf.getNumberFormat()).toPattern());
                System.err.println("\"");
            }
        } catch (ParseException pe) {
            if (expectedGC == null) {
                if (verbose) {
                    System.out.print("  Passed: SimpleDateFormat(" + locale);
                    System.out.print(", \"" + pattern + "\").parse(\"" + given);
                    System.out.println("\")");
                    System.out.println("      threw ParseException as expected");
                }
            } else {
                err = true;
                System.err.println("  Failed: Unexpected exception with");
                System.err.print("    SimpleDateFormat(" + locale);
                System.err.print(", \"" + pattern + "\").parse(\"");
                System.err.println(given + "\"):");
                System.err.println("      " + pe);
                System.err.print("      Pattern: \"");
                System.err.print(((DecimalFormat) sdf.getNumberFormat()).toPattern());
                System.err.println("\"");
                System.err.print("      Month 0: ");
                System.err.println(sdf.getDateFormatSymbols().getMonths()[0]);
            }
        }
        return given;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3434().testDateFormatParsing(sdf, pattern, given, expectedGC, locale);
    }
}
