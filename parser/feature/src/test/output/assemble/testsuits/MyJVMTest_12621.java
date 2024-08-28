import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_12621 {

    static String whyFailed = "e&uiEfK}:6";

    static Font customFont = null;

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    String fail(String whyFailed) {
        Sysout.println("The test failed: " + whyFailed);
        Sysout.println("The test is over, hit  Ctl-C to stop Java VM");
        if (mainThread == Thread.currentThread()) {
            throw new RuntimeException(whyFailed);
        }
        theTestPassed = false;
        testGeneratedInterrupt = true;
        failureMessage = whyFailed;
        mainThread.interrupt();
        return whyFailed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12621().fail(whyFailed);
    }
}
