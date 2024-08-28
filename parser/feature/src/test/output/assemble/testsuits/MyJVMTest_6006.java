import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_6006 {

    Calendar getISO8601() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(MONDAY);
        cal.setMinimalDaysInFirstWeek(4);
        cal.setGregorianChange(new Date(Long.MIN_VALUE));
        cal.clear();
        return cal;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6006().getISO8601());
    }
}
