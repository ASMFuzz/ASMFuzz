import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_3723 {

    static JFrame frame = null;

    static JDialog dialog = null;

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
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3723().pass();
    }
}
