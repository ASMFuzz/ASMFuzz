import java.util.Formatter;
import java.util.Locale;

public class MyJVMTest_15642 {

    static String localeParam1 = "ur|M`6J{!f";

    static String localeParam2 = ";nCyAzua|T";

    static String localeParam3 = "\\T%\\&'I% v";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    static String formatString = "E=Fhk*~rh\\";

    static Integer number = 0;

    Locale testFormatter(Locale locale, String formatString, Integer number) {
        String.format(locale, formatString, number);
        Formatter formatter = new Formatter(locale);
        formatter.format(formatString, number);
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15642().testFormatter(locale, formatString, number);
    }
}
