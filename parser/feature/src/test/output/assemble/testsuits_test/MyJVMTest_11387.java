import java.text.*;
import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_11387 {

    static String localeParam1 = "W_eA.+S5*v";

    static String localeParam2 = "|=H'ljR]D2";

    static Locale locale = new Locale(localeParam1, localeParam2);

    static int formatStyle = 1;

    static int standaloneStyle = -1608415181;

    static int errors = 0;

    Locale testDisplayNames(Locale locale, int formatStyle, int standaloneStyle) {
        Map<String, Integer> map = new HashMap<>();
        for (int month = JANUARY; month <= DECEMBER; month++) {
            Calendar cal = new GregorianCalendar(2015, month, 1);
            String format = cal.getDisplayName(MONTH, formatStyle, locale);
            String standalone = cal.getDisplayName(MONTH, standaloneStyle, locale);
            if (!format.equals(standalone)) {
                System.err.println("Calendar.getDisplayName: " + (month + 1) + ", locale=" + locale + ", format=" + format + ", standalone=" + standalone);
                errors++;
            }
            if (standalone != null) {
                map.put(standalone, month);
            }
        }
        if (formatStyle == NARROW_FORMAT) {
            return;
        }
        Calendar cal = new GregorianCalendar(2015, JANUARY, 1);
        Map<String, Integer> mapStandalone = cal.getDisplayNames(MONTH, standaloneStyle, locale);
        if (!map.equals(mapStandalone)) {
            System.err.printf("Calendar.getDisplayNames: locale=%s%n    map=%s%n    mapStandalone=%s%n", locale, map, mapStandalone);
            errors++;
        }
        Map<String, Integer> mapAll = cal.getDisplayNames(MONTH, ALL_STYLES, locale);
        if (!mapAll.entrySet().containsAll(map.entrySet())) {
            System.err.printf("Calendar.getDisplayNames: locale=%s%n    map=%s%n    mapAll=%s%n", locale, map, mapAll);
            errors++;
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11387().testDisplayNames(locale, formatStyle, standaloneStyle);
    }
}
