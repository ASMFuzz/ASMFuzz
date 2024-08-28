import java.util.prefs.*;

public class MyJVMTest_5828 {

    static int itr = 0;

    static String methodName = "<,rmZFslC{";

    static boolean failed = false;

    String checkPassItr(int itr, String methodName) {
        if (itr == 0) {
            System.out.println(methodName + " test passed");
        } else {
            failed = true;
            if (itr == -1) {
                throw new RuntimeException("Failed in " + methodName + " - change listener never notified");
            } else {
                throw new RuntimeException("Failed in " + methodName + " - listener notified on iteration " + itr);
            }
        }
        return methodName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5828().checkPassItr(itr, methodName);
    }
}
