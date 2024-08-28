import java.lang.reflect.*;
import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_11614 {

    static int calParam1 = 656;

    static int calParam2 = 738;

    static int calParam3 = 203;

    static int calParam4 = 476;

    static int calParam5 = 282;

    static Calendar cal = new GregorianCalendar(calParam1, calParam2, calParam3, calParam4, calParam5);

    Calendar invoke(Calendar cal) {
        cal.clear();
        cal.set(2000, NOVEMBER, 2, 0, 0, 0);
        int y = cal.get(YEAR);
        int m = cal.get(MONTH);
        int d = cal.get(DAY_OF_MONTH);
        if (y != 2000 || m != NOVEMBER || d != 2) {
            throw new RuntimeException("wrong date produced (" + y + "/" + (m + 1) + "/" + d + ")");
        }
        return cal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11614().invoke(cal);
    }
}
