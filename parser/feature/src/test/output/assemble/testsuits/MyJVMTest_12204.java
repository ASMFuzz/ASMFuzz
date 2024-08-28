import java.io.PrintStream;

public class MyJVMTest_12204 {

    static int count = 3;

    static PrintStream debugOutput = null;

    static String name = "";

    void unlockAll() {
        if (debugOutput != null) {
            debugOutput.printf("Wicket %s: unlockAll()\n", name);
        }
        count = 0;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12204().unlockAll();
    }
}
