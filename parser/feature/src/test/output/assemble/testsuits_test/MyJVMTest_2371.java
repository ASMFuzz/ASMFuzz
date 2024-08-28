import java.util.*;
import java.util.function.*;

public class MyJVMTest_2371 {

    static Function<String, String> testFunc = null;

    static String testFuncName = "\"Ry?+(vH1v";

    int testRNN_NonNull(Function<String, String> testFunc, String testFuncName) {
        int errors = 0;
        try {
            String s = testFunc.apply("pants");
            if (s != "pants") {
                System.err.printf(testFuncName + " failed to return its arg");
                errors++;
            }
        } catch (NullPointerException e) {
            System.err.printf(testFuncName + " threw unexpected NPE");
            errors++;
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2371().testRNN_NonNull(testFunc, testFuncName));
    }
}
