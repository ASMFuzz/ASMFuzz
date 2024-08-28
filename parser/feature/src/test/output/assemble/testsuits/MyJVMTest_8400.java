import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_8400 {

    static String actual = "$Y[,9Noqg)";

    static String expected = ",/7J*<oW1W";

    String check(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new Error("Selection error: expected " + expected + " but got " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8400().check(actual, expected);
    }
}
