import java.io.PrintStream;

public class MyJVMTest_9570 {

    static long timeout = -9223372036854775808L;

    static int count = 1960839792;

    static int waiters = 0;

    static PrintStream debugOutput = null;

    static String name = "";

    int waitFor(long timeout) {
        if (debugOutput != null) {
            debugOutput.printf("Wicket %s: waitFor(%d)\n", name, timeout);
        }
        if (timeout < 0)
            throw new IllegalArgumentException("timeout value is negative: " + timeout);
        ++waiters;
        long waitTime = timeout;
        long startTime = System.currentTimeMillis();
        while (count > 0 && waitTime > 0) {
            try {
                wait(waitTime);
            } catch (InterruptedException e) {
            }
            waitTime = timeout - (System.currentTimeMillis() - startTime);
        }
        --waiters;
        return (count);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9570().waitFor(timeout));
    }
}
