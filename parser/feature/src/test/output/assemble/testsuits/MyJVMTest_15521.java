import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_15521 {

    static int calParam1Param1 = 670;

    static String calParam1Param2 = "/YTZ;-[sL[";

    static int calParam1Param3 = 778;

    static int calParam1Param4 = 475;

    static int calParam1Param5 = 83;

    static int calParam1Param6 = 380;

    static int calParam1Param7 = 291;

    static int calParam1Param8 = 386;

    static int calParam1Param9 = 219;

    static int calParam1Param10 = 290;

    static int calParam1Param11 = 156;

    static int calParam1Param12 = 471;

    static int calParam1Param13 = 317;

    static TimeZone calParam1 = new SimpleTimeZone(calParam1Param1, calParam1Param2, calParam1Param3, calParam1Param4, calParam1Param5, calParam1Param6, calParam1Param7, calParam1Param8, calParam1Param9, calParam1Param10, calParam1Param11, calParam1Param12, calParam1Param13);

    static Calendar cal = new GregorianCalendar(calParam1);

    static int n = 6;

    int roll(Calendar cal, int n) {
        int doy = cal.get(DAY_OF_YEAR);
        int diff = cal.get(DAY_OF_WEEK) - cal.getFirstDayOfWeek();
        if (diff < 0) {
            diff += 7;
        }
        int dow1 = doy - diff;
        n %= 7;
        doy += n;
        if (doy < dow1) {
            doy += 7;
        } else if (doy >= dow1 + 7) {
            doy -= 7;
        }
        cal.set(DAY_OF_YEAR, doy);
        return doy;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15521().roll(cal, n);
    }
}
