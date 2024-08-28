import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_16214 {

    static Calendar cal = new GregorianCalendar();

    static int expectedParam1Param1 = 91;

    static String expectedParam1Param2 = ";7.-,-w;)A";

    static TimeZone expectedParam1 = new SimpleTimeZone(expectedParam1Param1, expectedParam1Param2);

    static Calendar expected = new GregorianCalendar(expectedParam1);

    static int error = 0;

    Calendar check(Calendar cal, Calendar expected) {
        if (!cal.equals(expected)) {
            error++;
            System.err.println("FAILED:");
            System.err.println("\t     cal = " + cal.getTime());
            System.err.println("\texpected = " + expected.getTime());
            System.err.printf("\tcal = %s%n\texp = %s%n", cal, expected);
        }
        return cal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16214().check(cal, expected);
    }
}
