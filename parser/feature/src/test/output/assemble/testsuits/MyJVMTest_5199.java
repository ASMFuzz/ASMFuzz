import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_5199 {

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static AtomicIntegerArray counters = null;

    static AtomicInteger clearCounter = new AtomicInteger();

    static boolean runrun = true;

    static int id = 3;

    static int index = 0;

    static Locale locale = null;

    static String str = "Cq$>|aowy@";

    static int max = -2103381669;

    static boolean cleaner = true;

    static ResourceBundle.Control control = null;

    void run() {
        while (runrun) {
            ResourceBundle rb = ResourceBundle.getBundle("StressOut", locale, control);
            counters.incrementAndGet(id);
            String s = rb.getString("data");
            if (!s.equals(str)) {
                runrun = false;
                throw new RuntimeException(locale + ": rb.locale=" + rb.getLocale() + ", got " + s + ", expected " + str);
            }
            try {
                Thread.sleep(rand.nextInt(max / 500));
            } catch (InterruptedException e) {
            }
            if (cleaner && (rand.nextInt(10000) == 0)) {
                ResourceBundle.clearCache();
                clearCounter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5199().run();
    }
}
