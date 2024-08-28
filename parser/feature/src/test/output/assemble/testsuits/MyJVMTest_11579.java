import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_11579 {

    static int stzParam1 = 652;

    static String stzParam2 = "i`e-xXK)No";

    static SimpleTimeZone stz = new SimpleTimeZone(stzParam1, stzParam2);

    static int errors = 0;

    SimpleTimeZone testSimpleTimeZone(SimpleTimeZone stz) {
        if (stz.useDaylightTime() != stz.observesDaylightTime()) {
            System.err.printf("Failed: useDaylightTime=%b, observesDaylightTime()=%b%n\t%s%n", stz.useDaylightTime(), stz.observesDaylightTime(), stz);
            errors++;
        }
        return stz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11579().testSimpleTimeZone(stz);
    }
}
