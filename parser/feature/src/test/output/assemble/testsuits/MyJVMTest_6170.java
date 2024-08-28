import java.util.Formatter;
import java.util.Locale;

public class MyJVMTest_6170 {

    static String localeParam1 = "i#QF Q#{aG";

    static String localeParam2 = "!c@s[a^}q8";

    static String localeParam3 = "1v8I/=1S}e";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    static String formatString = "kCg:QZ\"Nmw";

    static Integer number = -1740060817;

    Locale testFormatter(Locale locale, String formatString, Integer number) {
        String.format(locale, formatString, number);
        Formatter formatter = new Formatter(locale);
        formatter.format(formatString, number);
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6170().testFormatter(locale, formatString, number);
    }
}
