import java.lang.instrument.Instrumentation;

public class MyJVMTest_11188 {

    static String agentArg = "R@[/5/jGV}";

    static Instrumentation instrumentation = null;

    void waitForThreadStart() {
        try {
            synchronized (lock) {
                while (!threadStarted) {
                    lock.wait();
                }
                System.out.println("Thread has started");
            }
        } catch (Throwable t) {
            System.err.println("Unexpected: " + t);
            throw new RuntimeException(t);
        }
    }

    static boolean threadStarted = false;

    static Object lock = new Object();

    Thread premain(String agentArg, Instrumentation instrumentation) {
        System.out.println("inside LockDuringDumpAgent: " + LockDuringDumpAgent.class.getClassLoader());
        Thread t = new Thread(new LockDuringDumpAgent());
        t.setDaemon(true);
        t.start();
        waitForThreadStart();
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11188().premain(agentArg, instrumentation);
    }
}
