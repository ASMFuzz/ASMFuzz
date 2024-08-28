import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_12534 {

    static String baseName = "p|c@]0LYZi";

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static int id = 4;

    static int index = 4;

    static Locale locale = null;

    static String str = "eUt(@V}7D<";

    static int max = 0;

    static boolean cleaner = true;

    static ResourceBundle.Control control = null;

    long getTimeToLive(String baseName, Locale locale) {
        long ttl = rand.nextInt(max);
        return ttl;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12534().getTimeToLive(baseName, locale));
    }
}
