import java.awt.BorderLayout;

public class MyJVMTest_1994 {

    static Thread mainThread = null;

    static boolean testPassed = false;

    static boolean testGeneratedInterrupt = true;

    void pass() {
        testPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1994().pass();
    }
}
