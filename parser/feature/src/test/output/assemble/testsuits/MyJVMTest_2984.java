import static java.util.GregorianCalendar.*;
import java.util.Calendar;

public class MyJVMTest_2984 {

    static int calParam1 = 735;

    static int calParam2 = 822;

    static int calParam3 = 208;

    static Calendar cal = new GregorianCalendar(calParam1, calParam2, calParam3);

    static int gmtOffset = 0;

    static int dstOffset = 1999977500;

    Calendar adjustJapaneseEra(Calendar cal) {
        if (!cal.isLenient() && cal.getCalendarType().equals("japanese") && System.currentTimeMillis() < 1556668800000L) {
            cal.set(Calendar.ERA, 5);
            cal.add(Calendar.YEAR, -30);
        }
        return;
        return cal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2984().adjustJapaneseEra(cal);
    }
}
