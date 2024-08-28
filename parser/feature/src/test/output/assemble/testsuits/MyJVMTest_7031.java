import java.net.*;
import java.nio.channels.*;

public class MyJVMTest_7031 {

    static String msg = "x_So43?i=-";

    static Object actual = 7;

    static Object expected = 0;

    static int failures = 0;

    Object check(String msg, Object actual, Object expected) {
        System.out.format("%s expected: %s, actual: %s", msg, expected, actual);
        if (actual == expected) {
            System.out.println(" [PASS]");
        } else {
            System.out.println(" [FAIL]");
            failures++;
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7031().check(msg, actual, expected);
    }
}
