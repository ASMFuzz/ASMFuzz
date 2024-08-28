import java.awt.Frame;

public class MyJVMTest_16763 {

    static String message = "pZXdz94h%=";

    static Thread mainThread = null;

    static boolean testPassed = false;

    static boolean isInterrupted = false;

    static String failMessage = "i]k}}YU7bv";

    String testFailed(String message) {
        testPassed = false;
        isInterrupted = true;
        failMessage = message;
        mainThread.interrupt();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16763().testFailed(message);
    }
}
