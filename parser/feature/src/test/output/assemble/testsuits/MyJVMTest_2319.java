import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_2319 {

    static int stzParam1 = 605;

    static String stzParam2 = ":1/*eJYm*Q";

    static int stzParam3 = 416;

    static int stzParam4 = 811;

    static int stzParam5 = 393;

    static int stzParam6 = 352;

    static int stzParam7 = 305;

    static int stzParam8 = 720;

    static int stzParam9 = 490;

    static int stzParam10 = 984;

    static int stzParam11 = 24;

    static int stzParam12 = 595;

    static int stzParam13 = 104;

    static SimpleTimeZone stz = new SimpleTimeZone(stzParam1, stzParam2, stzParam3, stzParam4, stzParam5, stzParam6, stzParam7, stzParam8, stzParam9, stzParam10, stzParam11, stzParam12, stzParam13);

    static int errors = 0;

    SimpleTimeZone testSimpleTimeZone(SimpleTimeZone stz) {
        if (stz.useDaylightTime() != stz.observesDaylightTime()) {
            System.err.printf("Failed: useDaylightTime=%b, observesDaylightTime()=%b%n\t%s%n", stz.useDaylightTime(), stz.observesDaylightTime(), stz);
            errors++;
        }
        return stz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2319().testSimpleTimeZone(stz);
    }
}
