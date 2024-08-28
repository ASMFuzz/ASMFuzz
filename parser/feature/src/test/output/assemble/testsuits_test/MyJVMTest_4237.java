import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_4237 {

    static String locParam1 = "EBvv{d:}&b";

    static String locParam2 = "#u7Q2yf2X-";

    static Locale loc = new Locale(locParam1, locParam2);

    String toString(Locale loc) {
        if (loc == null)
            return "null";
        return "\"" + loc.getLanguage() + "_" + loc.getCountry() + "_" + loc.getVariant() + "\"";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4237().toString(loc));
    }
}
