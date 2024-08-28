import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_16561 {

    static String baseName = "cgyzbTNeHi";

    static String format = "2nJC C;r:t";

    static ClassLoader loader = null;

    static ResourceBundle bundle = new ListResourceBundle();

    static long loadTime = -7201355266885184138L;

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static int id = 0;

    static int index = 7;

    static Locale locale = null;

    static String str = "X06?>[7dqV";

    static int max = 4;

    static boolean cleaner = true;

    static ResourceBundle.Control control = null;

    boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
        return rand.nextBoolean();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16561().needsReload(baseName, locale, format, loader, bundle, loadTime));
    }
}
