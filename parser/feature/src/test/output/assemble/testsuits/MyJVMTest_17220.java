import java.io.PrintStream;

public class MyJVMTest_17220 {

    static int count = 0;

    static int waiters = 0;

    static PrintStream debugOutput = null;

    static String name = "";

    void waitFor() {
        ++waiters;
        if (debugOutput != null) {
            debugOutput.printf("Wicket %s: waitFor()\n", name);
        }
        while (count > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        --waiters;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17220().waitFor();
    }
}
