import java.util.spi.TimeZoneNameProvider;
import java.util.Locale;
import java.util.Arrays;

public class MyJVMTest_10400 {

    Locale[] getAvailableLocales() {
        Locale[] locales = { Locale.JAPAN };
        return locales;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10400().getAvailableLocales()));
    }
}
