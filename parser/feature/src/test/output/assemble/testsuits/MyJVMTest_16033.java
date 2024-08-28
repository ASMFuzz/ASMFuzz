import java.io.PrintStream;

public class MyJVMTest_16033 {

    static int count = 0;

    static int waiters = 0;

    static PrintStream debugOutput = null;

    static String name = "";

    int getWaiters() {
        if (debugOutput != null) {
            debugOutput.printf("Wicket %s: getWaiters()\n", name);
        }
        return waiters;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16033().getWaiters());
    }
}
