import java.awt.Frame;

public class MyJVMTest_6359 {

    void dispose() {
        if (mainFrame != null) {
            mainFrame.dispose();
        }
    }

    static Frame mainFrame = null;

    static String testStrEOL = "^(%iEbpw_0";

    static boolean isTestFail = false;

    static int testFailCount = -1669513999;

    static StringBuilder testFailMessage = null;

    void checkFailures() {
        if (isTestFail) {
            testFailMessage.insert(0, "Test Fail count : " + testFailCount + System.getProperty("line.separator"));
            dispose();
            throw new RuntimeException(testFailMessage.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6359().checkFailures();
    }
}
