import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_3626 {

    static String[][] data = { { "q)MpHGhgP{", "ufCQ>BGt}D", "vJI.@_{gKg", "0p:k!Z\"LGH", "F%CuX\"+U2}", "E}@rA%TU-1", "F*fis`7?fW", "wP&kn[YmmM", ".h&L` j4h?", ":1$\\HKl3qO" }, { "5Q0rKo$!3S", "mfKr9~i}\"v", "&w;Jk`aP5[", "uPz+x*(vTt", "Qz8 l1y#]0", "ZbZjZ^k@?&", "?)}\\s1GCG5", "hEc*r<}AUl", "e8z+(F,YDw", "DSX@IQ1L?Y" } };

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    Date parseTest(String[][] data) throws Exception {
        for (String[] dates : data) {
            String regularDate = dates[0];
            String weekDate = dates[1];
            Date date1 = null, date2 = null;
            date1 = ymdFormat.parse(regularDate);
            date2 = ywdFormat.parse(weekDate);
            if (!date1.equals(date2)) {
                System.err.println(regularDate + ": date1 = " + date1);
                System.err.println(weekDate + ": date2 = " + date2);
                throw new RuntimeException("parse: date1 != date2");
            }
        }
        return date1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3626().parseTest(data);
    }
}
