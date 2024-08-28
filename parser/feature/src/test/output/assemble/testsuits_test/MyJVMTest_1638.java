import java.text.*;
import java.util.*;

public class MyJVMTest_1638 {

    static String sdfParam1 = ";36UKbsR{~";

    static String sdfParam2Param1 = "_'NfmW2`w'";

    static Locale sdfParam2 = new Locale(sdfParam2Param1);

    static SimpleDateFormat sdf = new SimpleDateFormat(sdfParam1, sdfParam2);

    static String pattern = "'0D!asp36L";

    static int givenGCParam1 = 633;

    static int givenGCParam2 = 303;

    static int givenGCParam3 = 708;

    static int givenGCParam4 = 673;

    static int givenGCParam5 = 492;

    static GregorianCalendar givenGC = new GregorianCalendar(givenGCParam1, givenGCParam2, givenGCParam3, givenGCParam4, givenGCParam5);

    static String expected = "qe_`jSlz;n";

    static String locale = "&e/`[D'0Mk";

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
        new MyJVMTest_1638().testDateFormatFormatting(sdf, pattern, givenGC, expected, locale);
    }
}
