import java.text.*;
import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_5679 {

    static SimpleDateFormat sdf = new SimpleDateFormat();

    static int calParam1 = 148;

    static int calParam2 = 586;

    static int calParam3 = 816;

    static Calendar cal = new GregorianCalendar(calParam1, calParam2, calParam3);

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
        new MyJVMTest_5679().test(sdf, cal);
    }
}
