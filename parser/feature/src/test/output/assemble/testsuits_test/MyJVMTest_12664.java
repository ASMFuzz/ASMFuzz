import java.util.Locale;

public class MyJVMTest_12664 {

    static String currencyCode = " :H'{K.NUu";

    static String localeParam1 = "y)<6lq?GiR";

    static String localeParam2 = "3fz4An08O0";

    static Locale locale = new Locale(localeParam1, localeParam2);

    String getSymbol(String currencyCode, Locale locale) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12664().getSymbol(currencyCode, locale));
    }
}
