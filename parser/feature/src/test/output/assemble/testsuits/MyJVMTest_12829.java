import java.util.*;
import java.util.concurrent.ThreadFactory;

public class MyJVMTest_12829 {

    static String tParam1Param1Param1 = ",*([7I'Tg_";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1);

    static String tParam1Param2 = "Dpe%y^Sk/W";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static Runnable tParam2 = () -> {
    };

    static Thread t = new Thread(tParam1, tParam2);

    static Set<Thread> threads = new HashSet<Thread>();

    boolean created(Thread t) {
        synchronized (threads) {
            return threads.contains(t);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12829().created(t));
    }
}
