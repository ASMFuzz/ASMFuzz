import java.util.Locale;
import java.util.Scanner;

public class MyJVMTest_6286 {

    static String number = "]C3=)HbBS_";

    static String localeParam1 = "$SCt<Q4:n&";

    static String localeParam2 = "nRbQd_i31Q";

    static String localeParam3 = "Dk4;\"j\\SWp";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    static Number actual = null;

    Locale testScannerUseLocale(String number, Locale locale, Number actual) {
        Scanner sc = new Scanner(number).useLocale(locale);
        if (!sc.hasNextFloat() || sc.nextFloat() != actual.floatValue()) {
            throw new RuntimeException("[FAILED: With" + " java.locale.providers=SPI,COMPAT, Scanner" + ".hasNextFloat() or Scanner.nextFloat() is unable to" + " scan the given number: " + number + ", in the given" + " locale:" + locale + "]");
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6286().testScannerUseLocale(number, locale, actual);
    }
}
