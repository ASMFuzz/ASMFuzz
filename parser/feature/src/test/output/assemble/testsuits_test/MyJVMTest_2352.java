import java.lang.reflect.*;
import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_2352 {

    static int calParam1 = 545;

    static int calParam2 = 670;

    static int calParam3 = 250;

    static Calendar cal = new GregorianCalendar(calParam1, calParam2, calParam3);

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
        new MyJVMTest_2352().invoke(cal);
    }
}
