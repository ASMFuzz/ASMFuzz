import java.util.Locale;

public class MyJVMTest_17406 {

    static String in = "-Yi6_6yXRr";

    static String localeParam1 = "*,DG`3e`!5";

    static Locale locale = new Locale(localeParam1);

    static String expected = "zh :*juKV'";

    void test0(String in, Locale locale, String expected) {
        String result = in.toLowerCase(locale);
        if (!result.equals(expected)) {
            System.err.println("input: " + in + ", locale: " + locale + ", expected: " + expected + ", actual: " + result);
            throw new RuntimeException();
        }
    }

    String[] test(String in, Locale locale, String expected) {
        test0(in, locale, expected);
        for (String[] ss : new String[][] { new String[] { "abc", "abc" }, new String[] { "aBc", "abc" }, new String[] { "ABC", "abc" }, new String[] { "ab\u4e00", "ab\u4e00" }, new String[] { "aB\u4e00", "ab\u4e00" }, new String[] { "AB\u4e00", "ab\u4e00" }, new String[] { "ab\uD800\uDC00", "ab\uD800\uDC00" }, new String[] { "aB\uD800\uDC00", "ab\uD800\uDC00" }, new String[] { "AB\uD800\uDC00", "ab\uD800\uDC00" }, new String[] { "ab\uD801\uDC1C", "ab\uD801\uDC44" }, new String[] { "aB\uD801\uDC1C", "ab\uD801\uDC44" }, new String[] { "AB\uD801\uDC1C", "ab\uD801\uDC44" } }) {
            test0(ss[0] + " " + in, locale, ss[1] + " " + expected);
            test0(in + " " + ss[0], locale, expected + " " + ss[1]);
        }
        return ss;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17406().test(in, locale, expected);
    }
}
