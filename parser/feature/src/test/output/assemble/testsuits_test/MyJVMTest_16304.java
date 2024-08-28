import java.util.*;
import java.text.*;

public class MyJVMTest_16304 {

    void dateTest() throws RuntimeException {
        Locale locTH = new Locale("th", "TH", "TH");
        TimeZone tz = TimeZone.getTimeZone("PST");
        Calendar calGregorian = Calendar.getInstance(tz, Locale.US);
        calGregorian.clear();
        calGregorian.set(2002, 4, 1, 8, 30);
        final Date date = calGregorian.getTime();
        Calendar cal = Calendar.getInstance(tz, locTH);
        cal.clear();
        cal.setTime(date);
        final String strExpected = "\u0E27\u0E31\u0E19\u0E1E\u0E38\u0E18\u0E17\u0E35\u0E48\u0020\u0E51\u0020\u0E1E\u0E24\u0E29\u0E20\u0E32\u0E04\u0E21\u0020\u0E1E\u002E\u0E28\u002E\u0020\u0E52\u0E55\u0E54\u0E55\u002C\u0020\u0E58\u0020\u0E19\u0E32\u0E2C\u0E34\u0E01\u0E32\u0020\u0E53\u0E50\u0020\u0E19\u0E32\u0E17\u0E35\u0020\u0E50\u0E50\u0020\u0E27\u0E34\u0E19\u0E32\u0E17\u0E35";
        Date value = cal.getTime();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locTH);
        df.setTimeZone(tz);
        String str = df.format(value);
        if (!strExpected.equals(str)) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16304().dateTest();
    }
}
