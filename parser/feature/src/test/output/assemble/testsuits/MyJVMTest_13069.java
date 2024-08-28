import java.awt.BorderLayout;

public class MyJVMTest_13069 {

    static Thread mainThread = null;

    static boolean testPassed = true;

    static boolean testGeneratedInterrupt = false;

    void fail() {
        testPassed = false;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13069().fail();
    }
}
