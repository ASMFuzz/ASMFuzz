import java.awt.Button;

public class MyJVMTest_6880 {

    static boolean testPassed = false;

    static Thread mainThread = null;

    static boolean testGeneratedInterrupt = false;

    void pass() {
        testPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6880().pass();
    }
}
