import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4888 {

    static Point pt = null;

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static Thread mainThread = null;

    void pass() {
        System.out.println("The test passed.");
        System.out.println("The test is over, hit  Ctl-C to stop Java VM");
        if (mainThread == Thread.currentThread()) {
            theTestPassed = true;
            throw new TestPassedException();
        }
        theTestPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4888().pass();
    }
}
