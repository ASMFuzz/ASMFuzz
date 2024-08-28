import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_17580 {

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    GregorianCalendar newCalendar() {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        cal.setFirstDayOfWeek(MONDAY);
        cal.setMinimalDaysInFirstWeek(4);
        return cal;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17580().newCalendar());
    }
}
