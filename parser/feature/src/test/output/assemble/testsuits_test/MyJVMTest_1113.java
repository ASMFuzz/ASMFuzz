import java.util.*;

public class MyJVMTest_1113 {

    static String testName = "eTE'8o?G^b";

    static int failCount = 5;

    static boolean failure = false;

    int report(String testName, int failCount) {
        System.err.println(testName + ": " + (failCount == 0 ? "Passed" : "Failed(" + failCount + ")"));
        if (failCount > 0)
            failure = true;
        return failCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1113().report(testName, failCount);
    }
}
