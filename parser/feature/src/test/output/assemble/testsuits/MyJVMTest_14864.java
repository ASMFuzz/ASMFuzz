import java.text.*;
import java.time.*;
import java.util.*;

public class MyJVMTest_14864 {

    static String localeParam1 = "j}jE_B4Kjx";

    static String localeParam2 = "T@SL=1@tV2";

    static String localeParam3 = "0eg)XTm^3!";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    static String date = "wO qyt8\\rK";

    static String tz = "b83Qs}f|p6";

    Locale testParse(Locale locale, String date, String tz) {
        try {
            new SimpleDateFormat("EEE MMM d hh:mm:ss z yyyy", locale).parse(date);
            System.out.println(String.format(Locale.ENGLISH, "OK parsing '%s' in locale '%s', tz: %s", date, locale, tz));
        } catch (ParseException pe) {
            throw new RuntimeException(String.format(Locale.ENGLISH, "ERROR parsing '%s' in locale '%s', tz: %s: %s", date, locale, tz, pe.toString()));
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14864().testParse(locale, date, tz);
    }
}
