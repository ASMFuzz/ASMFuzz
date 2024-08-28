import java.awt.BorderLayout;

public class MyJVMTest_3731 {

    static Thread mainThread = null;

    static boolean testPassed = false;

    static boolean testGeneratedInterrupt = true;

    void fail() {
        testPassed = false;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3731().fail();
    }
}
