import java.util.*;

public class MyJVMTest_10728 {

    static boolean condition = true;

    static String diagnostic = "$K'p(MNaYy";

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
        new MyJVMTest_10728().check(condition, diagnostic);
    }
}
