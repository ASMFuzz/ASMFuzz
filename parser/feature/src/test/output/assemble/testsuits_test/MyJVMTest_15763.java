import java.util.Locale;
import java.util.Scanner;

public class MyJVMTest_15763 {

    static String number = "3ltUjeeI)*";

    static String localeParam1 = ";8[fVk.-Pj";

    static String localeParam2 = "'Sc#R14h*O";

    static Locale locale = new Locale(localeParam1, localeParam2);

    static Number actual = null;

    Locale testScannerUseLocale(String number, Locale locale, Number actual) {
        Scanner sc = new Scanner(number).useLocale(locale);
        if (!sc.hasNextFloat() || sc.nextFloat() != actual.floatValue()) {
            throw new RuntimeException("[FAILED: With" + " java.locale.providers=SPI,COMPAT, Scanner" + ".hasNextFloat() or Scanner.nextFloat() is unable to" + " scan the given number: " + number + ", in the given" + " locale:" + locale + "]");
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15763().testScannerUseLocale(number, locale, actual);
    }
}
