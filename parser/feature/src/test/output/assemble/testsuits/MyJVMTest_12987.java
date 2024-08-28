import java.util.Locale;

public class MyJVMTest_12987 {

    static String in = "No.ujK&-wj";

    static String localeParam1 = "B4/gx#$({h";

    static String localeParam2 = "do:XxGo1n^";

    static Locale locale = new Locale(localeParam1, localeParam2);

    static String expected = "xVn1 ?BmFb";

    Locale test0(String in, Locale locale, String expected) {
        String result = in.toLowerCase(locale);
        if (!result.equals(expected)) {
            System.err.println("input: " + in + ", locale: " + locale + ", expected: " + expected + ", actual: " + result);
            throw new RuntimeException();
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12987().test0(in, locale, expected);
    }
}
