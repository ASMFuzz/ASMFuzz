import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_3332 {

    static String[][] data = { { "[h!s9N*7yN", "Q'nU*]Mn3z", "@d%zQSLI[k", "J_c6*Zrs3g", "9u[%Y%oxz$", "q\\;o~,0Jft", "34|^G]7YAH", "y#Kme~6r*&", "G!]G>ZM_c+", "CXaS>&164?" }, { ";LF:?/I<>u", "JywV M.dTi", "UnhL}Or0}Q", "D}< 2}>c+Q", "qFk+Adu3;X", "$+ R5kO7+#", "tQkwZ_3Hia", "zX@C Doi\"/", "j5=3wZDlPG", "mIv=?~~3N|" } };

    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    static SimpleDateFormat ywdFormat = new SimpleDateFormat("YYYY-'W'ww-u", Locale.US);

    String formatTest(String[][] data) throws Exception {
        for (String[] dates : data) {
            String regularDate = dates[0];
            String weekDate = dates[1];
            Date date = null;
            date = ymdFormat.parse(regularDate);
            String s = ywdFormat.format(date);
            if (!s.equals(weekDate)) {
                throw new RuntimeException("format: got=" + s + ", expecetd=" + weekDate);
            }
        }
        return weekDate;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3332().formatTest(data);
    }
}
