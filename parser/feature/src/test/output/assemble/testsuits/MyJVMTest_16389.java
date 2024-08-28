import java.awt.Button;

public class MyJVMTest_16389 {

    static boolean testPassed = true;

    static Thread mainThread = null;

    static boolean testGeneratedInterrupt = true;

    void pass() {
        testPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16389().pass();
    }
}
