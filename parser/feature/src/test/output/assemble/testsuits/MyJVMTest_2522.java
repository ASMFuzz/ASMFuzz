import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_2522 {

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static AtomicIntegerArray counters = null;

    static AtomicInteger clearCounter = new AtomicInteger();

    static int id = 5;

    static int index = 1509313242;

    static Locale locale = null;

    static String str = "eg>fs.SR|s";

    static int max = 9;

    static boolean cleaner = true;

    static ResourceBundle.Control control = null;

    void printCounters() {
        long total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < counters.length(); i++) {
            int counter = counters.get(i);
            total += counter;
            min = Math.min(min, counter);
            max = Math.max(max, counter);
        }
        System.out.printf("Total: %d calls, min=%d, max=%d, cache cleared %d times%n", total, min, max, clearCounter.get());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2522().printCounters();
    }
}
