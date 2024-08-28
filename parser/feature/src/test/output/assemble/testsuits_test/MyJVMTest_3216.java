import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_3216 {

    static String baseName = "ua<j$3^ix4";

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static int id = 6;

    static int index = 1;

    static Locale locale = null;

    static String str = "/MgvN`WtF<";

    static int max = 0;

    static boolean cleaner = false;

    static ResourceBundle.Control control = null;

    long getTimeToLive(String baseName, Locale locale) {
        long ttl = rand.nextInt(max);
        return ttl;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3216().getTimeToLive(baseName, locale));
    }
}
