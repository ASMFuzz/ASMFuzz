import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_17984 {

    static String actual = "GUc\"BJZ|!l";

    static String expected = "L/,-f7b$z9";

    String check(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new Error("Selection error: expected " + expected + " but got " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17984().check(actual, expected);
    }
}
