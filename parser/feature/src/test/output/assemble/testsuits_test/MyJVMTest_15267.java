import java.util.ResourceBundle;
import java.util.Locale;

public class MyJVMTest_15267 {

    static String localeParam1 = "c@?%bddCg3";

    static Locale locale = new Locale(localeParam1);

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
        new MyJVMTest_15267().test(locale);
    }
}
