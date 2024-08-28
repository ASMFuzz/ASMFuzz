import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_11964 {

    static int numberOfThreads = 6;

    static Thread.UncaughtExceptionHandler eh = null;

    static Runnable task = () -> {
    };

    Thread execute(int numberOfThreads, Thread.UncaughtExceptionHandler eh, Runnable task) throws Exception {
        List<Thread> threads = new ArrayList<>();
        for (int n = 0; n < numberOfThreads; ++n) {
            Thread t = new Thread(task);
            t.setUncaughtExceptionHandler(eh);
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11964().execute(numberOfThreads, eh, task);
    }
}
