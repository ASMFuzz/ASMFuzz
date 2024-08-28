import java.util.*;
import java.util.function.*;

public class MyJVMTest_4570 {

    static Function<String, String> testFunc = null;

    static String testFuncName = "W'mI0l3M_r";

    static String expectedMessage = "cZrT~la,\"_";

    int testRNN_Null(Function<String, String> testFunc, String testFuncName, String expectedMessage) {
        int errors = 0;
        try {
            String s = testFunc.apply(null);
            System.err.printf(testFuncName + " failed to throw NPE");
            errors++;
        } catch (NullPointerException e) {
            if (e.getMessage() != expectedMessage) {
                System.err.printf(testFuncName + " threw NPE w/ bad detail msg");
                errors++;
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4570().testRNN_Null(testFunc, testFuncName, expectedMessage));
    }
}
