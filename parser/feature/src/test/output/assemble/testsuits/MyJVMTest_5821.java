import java.util.ResourceBundle;
import java.util.Locale;

public class MyJVMTest_5821 {

    static String localeParam1 = "1_XEf7}ErH";

    static String localeParam2 = "o~g[4==yq+";

    static Locale locale = new Locale(localeParam1, localeParam2);

    Locale test(Locale locale) {
        Locale.setDefault(locale);
        ResourceBundle myResources = ResourceBundle.getBundle("Test4318520RB", Locale.FRENCH);
        String actualLocale = myResources.getString("name");
        if (!actualLocale.equals(locale.toString())) {
            System.out.println("expected: " + locale + ", got: " + actualLocale);
            throw new RuntimeException();
        }
        return locale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5821().test(locale);
    }
}
