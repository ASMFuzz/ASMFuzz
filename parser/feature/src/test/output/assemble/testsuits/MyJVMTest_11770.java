import java.io.PrintStream;

public class MyJVMTest_11770 {

    static int count = -656945296;

    static PrintStream debugOutput = null;

    static String name = "";

    void unlock() {
        if (debugOutput != null) {
            debugOutput.printf("Wicket %s: unlock()\n", name);
        }
        if (count == 0)
            throw new IllegalStateException("locks are already open");
        --count;
        if (count == 0) {
            notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11770().unlock();
    }
}
