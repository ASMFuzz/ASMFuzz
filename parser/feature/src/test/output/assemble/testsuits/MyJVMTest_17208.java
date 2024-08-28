import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_17208 {

    static List<Locale> locales = new ArrayList<Locale>();

    String showLocales(List<Locale> locales) {
        StringBuilder sb = new StringBuilder();
        Iterator<Locale> itr = locales.iterator();
        if (itr.hasNext()) {
            sb.append(itr.next().toLanguageTag());
        }
        while (itr.hasNext()) {
            sb.append(", ");
            sb.append(itr.next().toLanguageTag());
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17208().showLocales(locales));
    }
}
