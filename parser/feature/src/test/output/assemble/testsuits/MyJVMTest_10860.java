import java.text.*;
import java.util.*;

public class MyJVMTest_10860 {

    static String sdfParam1 = "Kk5&w19\\o+";

    static SimpleDateFormat sdf = new SimpleDateFormat(sdfParam1);

    static String pattern = "jPCWwEp{Gd";

    static int givenGCParam1 = 983;

    static int givenGCParam2 = 59;

    static int givenGCParam3 = 965;

    static GregorianCalendar givenGC = new GregorianCalendar(givenGCParam1, givenGCParam2, givenGCParam3);

    static String expected = ";m<Cs<Os4\\";

    static String locale = "{ix]yU0 Os";

    static int ERA = Calendar.ERA;

    static int BC = GregorianCalendar.BC;

    static boolean err = false;

    static boolean verbose = false;

    GregorianCalendar testDateFormatFormatting(SimpleDateFormat sdf, String pattern, GregorianCalendar givenGC, String expected, String locale) {
        Date given = givenGC.getTime();
        String str = sdf.format(given);
        if (expected.equals(str)) {
            if (verbose) {
                System.out.print("  Passed: SimpleDateFormat(");
                System.out.print(locale + ", \"" + pattern + "\").format(");
                System.out.println(given + ")");
                System.out.print("      ---> \"" + str + "\" ");
                System.out.println((givenGC.get(ERA) == BC) ? "(BC)" : "(AD)");
            }
        } else {
            err = true;
            System.err.print("  Failed: Unexpected SimpleDateFormat(");
            System.out.print(locale + ", \"" + pattern + "\").format(");
            System.out.println(given + ") result.");
            System.out.println("      Expected: \"" + expected + "\"");
            System.out.print("      Got:      \"" + str + "\" ");
            System.out.println((givenGC.get(ERA) == BC) ? "(BC)" : "(AD)");
        }
        return givenGC;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10860().testDateFormatFormatting(sdf, pattern, givenGC, expected, locale);
    }
}
