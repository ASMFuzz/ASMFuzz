import java.text.*;
import java.util.*;

public class MyJVMTest_5235 {

    static int style = 5;

    static boolean err = false;

    static Locale th = new Locale("th", "");

    static Locale th_TH = new Locale("th", "TH");

    static String[] expected_th = { "\u0e27\u0e31\u0e19\u0e2d\u0e31\u0e07\u0e04\u0e32\u0e23\u0e17\u0e35\u0e48 30 \u0e01\u0e31\u0e19\u0e22\u0e32\u0e22\u0e19 \u0e04.\u0e28. 2008, 8 \u0e19\u0e32\u0e2c\u0e34\u0e01\u0e32 0 \u0e19\u0e32\u0e17\u0e35 00 \u0e27\u0e34\u0e19\u0e32\u0e17\u0e35", "30 \u0e01\u0e31\u0e19\u0e22\u0e32\u0e22\u0e19 2008, 8 \u0e19\u0e32\u0e2c\u0e34\u0e01\u0e32 0 \u0e19\u0e32\u0e17\u0e35", "30 \u0e01.\u0e22. 2008, 8:00:00", "30/9/2008, 8:00 \u0e19." };

    static String[] expected_th_TH = { "\u0e27\u0e31\u0e19\u0e2d\u0e31\u0e07\u0e04\u0e32\u0e23\u0e17\u0e35\u0e48 30 \u0e01\u0e31\u0e19\u0e22\u0e32\u0e22\u0e19 \u0e1e.\u0e28. 2551, 8 \u0e19\u0e32\u0e2c\u0e34\u0e01\u0e32 0 \u0e19\u0e32\u0e17\u0e35 00 \u0e27\u0e34\u0e19\u0e32\u0e17\u0e35", "30 \u0e01\u0e31\u0e19\u0e22\u0e32\u0e22\u0e19 2551, 8 \u0e19\u0e32\u0e2c\u0e34\u0e01\u0e32 0 \u0e19\u0e32\u0e17\u0e35", "30 \u0e01.\u0e22. 2551, 8:00:00", "30/9/2551, 8:00 \u0e19." };

    static String[] stylePattern = { "FULL", "LONG", "MEDIUM", "SHORT" };

    int test(int style) {
        DateFormat df_th = DateFormat.getDateTimeInstance(style, style, th);
        DateFormat df_th_TH = DateFormat.getDateTimeInstance(style, style, th_TH);
        String str_th = ((SimpleDateFormat) df_th).toPattern();
        String str_th_TH = ((SimpleDateFormat) df_th_TH).toPattern();
        if (!str_th.equals(str_th_TH)) {
            err = true;
            System.err.println("Error: Pattern for th locale should be the same as pattern for th_TH locale. (" + stylePattern[style] + ")");
            System.err.println("\tth: " + str_th);
            System.err.println("\tth_TH: " + str_th_TH);
        }
        @SuppressWarnings("deprecation")
        Date date = new Date(2008 - 1900, Calendar.SEPTEMBER, 30, 8, 0, 0);
        str_th = df_th.format(date);
        if (!expected_th[style].equals(str_th)) {
            err = true;
            System.err.println("Error: Formatted date in th locale is incorrect in " + stylePattern[style] + " pattern.");
            System.err.println("\tExpected: " + expected_th[style]);
            System.err.println("\tGot: " + str_th);
        }
        str_th_TH = df_th_TH.format(date);
        if (!expected_th_TH[style].equals(str_th_TH)) {
            err = true;
            System.err.println("Error: Formatted date in th_TH locale is incorrect in " + stylePattern[style] + " pattern.");
            System.err.println("\tExpected: " + expected_th_TH[style]);
            System.err.println("\tGot: " + str_th_TH);
        }
        return style;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5235().test(style);
    }
}
