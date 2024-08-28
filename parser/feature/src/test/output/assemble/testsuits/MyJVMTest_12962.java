import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_12962 {

    static String[][] data = { { ":?87j`3fB`", "OK1~(F]k!&", "O0LT-nchi'", "o~`egWH9v}", "l$Xueb-99?", "1%^`[Oj^vs", "B8QTS$>Xs8", "KxxJNsj9qq", "8ni1V4}:&#", "5z=g5\"eo6h" }, { "Auyf(y,@Y@", "!'KL!pG\\a!", "7}82*T&,/d", "n,PMfSM(o6", "u_+g<\"BJRT", "Ioq?eyw=D-", "+]N?m\\F7Zq", "z, E^VW;cW", "d~-CDL);HE", "FH#e]TwPwf" } };

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    Date parseTest(String[][] data) throws Exception {
        for (String[] dates : data) {
            String regularDate = dates[0];
            String weekDate = dates[1];
            Date date1 = null, date2 = null;
            date1 = ymdFormat.parse(regularDate);
            date2 = ywdFormat.parse(weekDate);
            if (!date1.equals(date2)) {
                System.err.println(regularDate + ": date1 = " + date1);
                System.err.println(weekDate + ": date2 = " + date2);
                throw new RuntimeException("parse: date1 != date2");
            }
        }
        return date1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12962().parseTest(data);
    }
}
