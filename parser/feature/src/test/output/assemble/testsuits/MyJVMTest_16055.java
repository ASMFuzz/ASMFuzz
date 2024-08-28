import java.util.Locale;
import java.util.TimeZone;
import java.util.Arrays;

public class MyJVMTest_16055 {

    Locale[] getAvailableLocales() {
        return new Locale[] { Locale.getDefault() };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16055().getAvailableLocales()));
    }
}
