import java.util.Locale;

public class MyJVMTest_3650 {

    static String in = "0AlL}S;^i>";

    static String localeParam1 = "HtGd0sI&h:";

    static String localeParam2 = "MC<i%AhZMN";

    static Locale locale = new Locale(localeParam1, localeParam2);

    static String expected = "$|kB{_SSbU";

    Locale test0(String in, Locale locale, String expected) {
        String result = in.toLowerCase(locale);
        if (!result.equals(expected)) {
            System.err.println("input: " + in + ", locale: " + locale + ", expected: " + expected + ", actual: " + result);
            throw new RuntimeException();
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3650().test0(in, locale, expected);
    }
}
