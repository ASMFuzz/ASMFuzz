import java.io.*;
import static java.lang.System.*;

public class MyJVMTest_8477 {

    static boolean cond = false;

    static String msg = "()uLW.^#58";

    void fail(String failureMsg) {
        System.out.println(failureMsg);
        failures++;
    }

    static int failures = 0;

    boolean check(boolean cond, String msg) {
        if (!cond) {
            fail("test failed: " + msg);
            new Exception().printStackTrace();
        }
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8477().check(cond, msg);
    }
}
