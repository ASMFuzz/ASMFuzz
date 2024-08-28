import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_13603 {

    static String locParam1 = "ns/.:-G|V5";

    static Locale loc = new Locale(locParam1);

    String toString(Locale loc) {
        if (loc == null)
            return "null";
        return "\"" + loc.getLanguage() + "_" + loc.getCountry() + "_" + loc.getVariant() + "\"";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13603().toString(loc));
    }
}
