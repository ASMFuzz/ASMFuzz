import static java.util.GregorianCalendar.*;
import java.util.Calendar;
import java.util.Locale;

public class MyJVMTest_12289 {

    static String calParam1Param1 = "4<z|wk`f{:";

    static String calParam1Param2 = "Bj)rvau^Rv";

    static String calParam1Param3 = "9+#laZ9_xx";

    static Locale calParam1 = new Locale(calParam1Param1, calParam1Param2, calParam1Param3);

    static Calendar cal = new GregorianCalendar(calParam1);

    static int gmtOffset = 609217428;

    static int dstOffset = 3;

    Calendar adjustJapaneseEra(Calendar cal) {
        if (!cal.isLenient() && cal.getCalendarType().equals("japanese") && System.currentTimeMillis() < 1556668800000L) {
            cal.set(Calendar.ERA, 5);
            cal.add(Calendar.YEAR, -30);
        }
        return;
        return cal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12289().adjustJapaneseEra(cal);
    }
}
