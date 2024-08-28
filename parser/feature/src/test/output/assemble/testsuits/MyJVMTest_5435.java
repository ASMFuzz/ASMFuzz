import java.text.*;
import java.time.*;
import java.util.*;

public class MyJVMTest_5435 {

    static String localeParam1 = "x<-I,'|H?W";

    static String localeParam2 = "}e`cNkByV]";

    static String localeParam3 = "7xF`]-uvJ?";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    static String date = "O@{6Sz[((|";

    static String tz = ":Pltaoshj>";

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
        new MyJVMTest_5435().testParse(locale, date, tz);
    }
}
