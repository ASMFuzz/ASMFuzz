import java.util.*;
import java.text.*;
import java.sql.Date;

public class MyJVMTest_8184 {

    static int dateParam1 = 611;

    static int dateParam2 = 759;

    static int dateParam3 = 34;

    static Date date = new Date(dateParam1, dateParam2, dateParam3);

    static String locParam1 = "v{'h%DBhc-";

    static String locParam2 = "giL&\"U,z_;";

    static String locParam3 = "Jo~!fi8b(^";

    static Locale loc = new Locale(locParam1, locParam2, locParam3);

    String getDayofWeek(Date date, Locale loc) {
        return (new SimpleDateFormat("EEEE", loc)).format(date);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8184().getDayofWeek(date, loc));
    }
}
