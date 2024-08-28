import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_2332 {

    static String[] data = { "s0oH/3sf%w", "1r$zxrb>fI", "^RZ4^-TM\\D", "S[JPkYUYr$", "YH*RC1Du2S", "Nj6be_)**s", "7}SlMr'\\_f", "d:R6WMvA%C", "NULz)Tzyzj", "wl7%~wMIDW" };

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    String nonLenientTest(String[] data) {
        ywdFormat.setLenient(false);
        for (String date : data) {
            try {
                Date d = ywdFormat.parse(date);
                throw new RuntimeException("No ParseException thrown with " + date);
            } catch (ParseException e) {
            }
        }
        ywdFormat.setLenient(true);
        return date;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2332().nonLenientTest(data);
    }
}
