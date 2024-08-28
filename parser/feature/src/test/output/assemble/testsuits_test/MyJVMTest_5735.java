import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5735 {

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static Thread mainThread = null;

    void pass() {
        Sysout.println("The test passed.");
        Sysout.println("The test is over, hit  Ctl-C to stop Java VM");
        if (mainThread == Thread.currentThread()) {
            theTestPassed = true;
            throw new TestPassedException();
        }
        theTestPassed = true;
        testGeneratedInterrupt = true;
        if (mainThread != null) {
            mainThread.interrupt();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5735().pass();
    }
}
