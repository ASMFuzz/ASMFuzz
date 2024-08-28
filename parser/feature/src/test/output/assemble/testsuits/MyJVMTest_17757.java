import java.util.*;
import java.text.*;
import java.sql.Date;

public class MyJVMTest_17757 {

    static int dateParam1 = 697;

    static int dateParam2 = 505;

    static int dateParam3 = 45;

    static Date date = new Date(dateParam1, dateParam2, dateParam3);

    static String locParam1 = "Ao4TIt>MCt";

    static String locParam2 = "g\\V*g)Y\"NP";

    static String locParam3 = "nLqQ%qS{Th";

    static Locale loc = new Locale(locParam1, locParam2, locParam3);

    String getDayofWeek(Date date, Locale loc) {
        return (new SimpleDateFormat("EEEE", loc)).format(date);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17757().getDayofWeek(date, loc));
    }
}
