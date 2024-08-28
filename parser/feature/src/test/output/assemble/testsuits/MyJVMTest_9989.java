import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_9989 {

    GregorianCalendar newCalendar() {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        cal.setFirstDayOfWeek(MONDAY);
        cal.setMinimalDaysInFirstWeek(4);
        return cal;
    }

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    void noWeekDateSupport() throws Exception {
        Calendar jcal = Calendar.getInstance(TimeZone.getTimeZone("GMT"), new Locale("ja", "JP", "JP"));
        String format = "2-W01-2";
        int expectedYear = 2019;
        if (System.currentTimeMillis() < 1556668800000L) {
            format = "21-W01-3";
            expectedYear = 2008;
        }
        jcal.setFirstDayOfWeek(MONDAY);
        jcal.setMinimalDaysInFirstWeek(4);
        SimpleDateFormat sdf = new SimpleDateFormat("Y-'W'ww-u");
        sdf.setCalendar(jcal);
        Date d = sdf.parse(format);
        GregorianCalendar gcal = newCalendar();
        gcal.setTime(d);
        if (gcal.get(YEAR) != expectedYear || gcal.get(MONTH) != DECEMBER || gcal.get(DAY_OF_MONTH) != 31) {
            String s = String.format("noWeekDateSupport: got %04d-%02d-%02d, expected %4d-12-31%n", gcal.get(YEAR), gcal.get(MONTH) + 1, gcal.get(DAY_OF_MONTH), expectedYear);
            throw new RuntimeException(s);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9989().noWeekDateSupport();
    }
}
