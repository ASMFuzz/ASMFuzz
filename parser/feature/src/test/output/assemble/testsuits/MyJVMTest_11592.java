import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_11592 {

    static String[] data = { "N#to0nS<Na", "2+e\\I9Y'__", ".5Ik ka-eG", "nf]K|H\\W&~", "B=tlEro<Q-", "O@!:jBa:M]", "!SwdAOKD9_", "L:<Zw.2(>W", "[DBW=]C7>Z", "fMYb[cz#}}" };

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
        new MyJVMTest_11592().nonLenientTest(data);
    }
}
