import java.util.*;

public class MyJVMTest_10308 {

    static String testName = "ZU1Y9l nO3";

    static int failCount = -1397581306;

    static boolean failure = false;

    int report(String testName, int failCount) {
        System.err.println(testName + ": " + (failCount == 0 ? "Passed" : "Failed(" + failCount + ")"));
        if (failCount > 0)
            failure = true;
        return failCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10308().report(testName, failCount);
    }
}
