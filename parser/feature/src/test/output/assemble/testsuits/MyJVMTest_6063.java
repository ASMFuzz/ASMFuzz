import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_6063 {

    static int calParam1 = 863;

    static int calParam2 = 7;

    static int calParam3 = 385;

    static int calParam4 = 167;

    static int calParam5 = 535;

    static Calendar cal = new GregorianCalendar(calParam1, calParam2, calParam3, calParam4, calParam5);

    static int n = 1;

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
        new MyJVMTest_6063().roll(cal, n);
    }
}
