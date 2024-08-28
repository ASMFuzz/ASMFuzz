import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_15115 {

    static String sdfParam1 = "'(4RE92%lt";

    static String sdfParam2Param1 = "m=Yf;-@)oL";

    static Locale sdfParam2 = new Locale(sdfParam2Param1);

    static SimpleDateFormat sdf = new SimpleDateFormat(sdfParam1, sdfParam2);

    static Calendar cal = new GregorianCalendar();

    String test(SimpleDateFormat sdf, Calendar cal) throws Exception {
        Date d = cal.getTime();
        String f = sdf.format(d);
        System.out.println(f);
        Date pd = sdf.parse(f);
        String p = sdf.format(pd);
        if (!d.equals(pd) || !f.equals(p)) {
            throw new RuntimeException("format: " + f + ", parse: " + p);
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15115().test(sdf, cal);
    }
}
