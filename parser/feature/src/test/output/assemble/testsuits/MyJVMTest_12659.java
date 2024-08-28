import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_12659 {

    static String[][] data = { { "Z-k4JZp]'x", "_E{VA;48BL", "U+\\y>3\\7x}", "P0^!q9~Ch\\", "\\5BrNSpnfr", "q)>?'ID&WC", "d`E%8y $&T", "|&g_y3='iD", "qTl7ZI9_/t", "#<7XO,*j#4" }, { ":/W-4zyIX*", "\"]gS o0^a$", "6t\"z?+]*;{", "@#)Vrjp>Fv", "*<M X[@p 5", "0]N7dM_#Ex", "h7_GW)*dtM", "wFbb\\x-B}+", "uvaNcJ@Aw{", "\"a:+2=;kk'" } };

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    String formatTest(String[][] data) throws Exception {
        for (String[] dates : data) {
            String regularDate = dates[0];
            String weekDate = dates[1];
            Date date = null;
            date = ymdFormat.parse(regularDate);
            String s = ywdFormat.format(date);
            if (!s.equals(weekDate)) {
                throw new RuntimeException("format: got=" + s + ", expecetd=" + weekDate);
            }
        }
        return weekDate;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12659().formatTest(data);
    }
}
