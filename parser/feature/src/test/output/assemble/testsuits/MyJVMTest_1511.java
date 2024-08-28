import java.util.*;

public class MyJVMTest_1511 {

    static boolean condition = true;

    static String diagnostic = "6#A^yT7i*D";

    void fail(String diagnostic) {
        new Error(diagnostic).printStackTrace();
        failure = true;
    }

    static boolean failure = false;

    String check(boolean condition, String diagnostic) {
        if (!condition)
            fail(diagnostic);
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1511().check(condition, diagnostic);
    }
}
