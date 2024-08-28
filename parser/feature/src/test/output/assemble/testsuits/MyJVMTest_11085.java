import java.util.*;
import java.util.concurrent.ThreadFactory;

public class MyJVMTest_11085 {

    static Runnable r = () -> {
    };

    static Set<Thread> threads = new HashSet<Thread>();

    Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        synchronized (threads) {
            threads.add(t);
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11085().newThread(r));
    }
}
