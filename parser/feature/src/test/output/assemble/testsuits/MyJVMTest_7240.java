import java.awt.Frame;

public class MyJVMTest_7240 {

    static String message = "YHH2.{F+Yg";

    static Thread mainThread = null;

    static boolean testPassed = false;

    static boolean isInterrupted = false;

    static String failMessage = "T$O9>jS# G";

    String testFailed(String message) {
        testPassed = false;
        isInterrupted = true;
        failMessage = message;
        mainThread.interrupt();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7240().testFailed(message);
    }
}
