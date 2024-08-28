import java.util.Locale;
import java.util.Arrays;

public class MyJVMTest_2341 {

    Locale[] getAvailableLocales() {
        Locale[] avail = new Locale[1];
        avail[0] = Locale.US;
        return avail;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2341().getAvailableLocales()));
    }
}
