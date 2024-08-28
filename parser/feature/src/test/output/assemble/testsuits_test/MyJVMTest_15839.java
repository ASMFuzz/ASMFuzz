import java.awt.Frame;

public class MyJVMTest_15839 {

    void dispose() {
        if (mainFrame != null) {
            mainFrame.dispose();
        }
    }

    static Frame mainFrame = null;

    static String testStrEOL = "KX?37R1)}Y";

    static boolean isTestFail = false;

    static int testFailCount = 1;

    static StringBuilder testFailMessage = null;

    void checkFailures() {
        if (isTestFail) {
            testFailMessage.insert(0, "Test Fail count : " + testFailCount + System.getProperty("line.separator"));
            dispose();
            throw new RuntimeException(testFailMessage.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15839().checkFailures();
    }
}
