import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_7044 {

    static String baseName = "+D=Rday')0";

    static String format = "ru<Y(:tDd~";

    static ClassLoader loader = null;

    static ResourceBundle bundle = new ListResourceBundle();

    static long loadTime = -9223372036854775808L;

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static int id = 7;

    static int index = 7;

    static Locale locale = null;

    static String str = "MH=Q\\h Fgt";

    static int max = 1;

    static boolean cleaner = true;

    static ResourceBundle.Control control = null;

    boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
        return rand.nextBoolean();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7044().needsReload(baseName, locale, format, loader, bundle, loadTime));
    }
}
