import java.util.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_16184 {

    static Locale ROOT_LOCALE = new Locale("");

    static Random rand = new Random();

    static Locale[] locales = { Locale.US, Locale.CHINA, ROOT_LOCALE, Locale.JAPAN, Locale.CANADA, Locale.KOREA };

    static String[] expected = { "U.S.A.", "China", "U.S.A.", "Japan", "U.S.A.", "Korea" };

    static AtomicIntegerArray counters = null;

    static int[] prevCounters = {4,706460336,8,-879302937,7,1,-698032247,1,-1669395733,4};

    static int intervalForCounterCheck = 9;

    static int id = 0;

    static int index = 4;

    static Locale locale = null;

    static String str = "(,&vjTu Cb";

    static int max = 5;

    static boolean cleaner = false;

    static ResourceBundle.Control control = null;

    void checkCounters() {
        int length = counters.length();
        int[] snapshot = new int[length];
        for (int i = 0; i < length; i++) {
            snapshot[i] = counters.get(i);
        }
        if (prevCounters == null) {
            prevCounters = snapshot;
            return;
        }
        for (int i = 0; i < length; i++) {
            if (snapshot[i] > prevCounters[i]) {
                continue;
            }
            System.out.printf("Warning: Thread #%d hasn't updated its counter for the last %d second(s).%n", i, intervalForCounterCheck);
        }
        prevCounters = snapshot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16184().checkCounters();
    }
}
