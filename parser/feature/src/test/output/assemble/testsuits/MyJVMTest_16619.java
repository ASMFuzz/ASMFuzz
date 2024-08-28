import java.util.*;

public class MyJVMTest_16619 {

    static Locale[] locales = { new Locale("ja", "JP", "JP"), new Locale("th", "TH", "TH"), Locale.forLanguageTag("en-US-u-ca-buddhist") };

    Locale[] getAvailableLocales() {
        return locales.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16619().getAvailableLocales()));
    }
}
