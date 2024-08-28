import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_7191 {

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
        jcal.setFirstDayOfWeek(MONDAY);
        jcal.setMinimalDaysInFirstWeek(4);
        SimpleDateFormat sdf = new SimpleDateFormat("Y-'W'ww-u");
        sdf.setCalendar(jcal);
        Date d = sdf.parse("21-W01-3");
        GregorianCalendar gcal = newCalendar();
        gcal.setTime(d);
        if (gcal.get(YEAR) != 2008 || gcal.get(MONTH) != DECEMBER || gcal.get(DAY_OF_MONTH) != 31) {
            String s = String.format("noWeekDateSupport: got %04d-%02d-%02d, expected 2008-12-31%n", gcal.get(YEAR), gcal.get(MONTH) + 1, gcal.get(DAY_OF_MONTH));
            throw new RuntimeException(s);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7191().noWeekDateSupport();
    }
}
