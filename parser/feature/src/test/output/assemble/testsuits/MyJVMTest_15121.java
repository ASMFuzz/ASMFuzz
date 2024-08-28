import java.util.*;
import java.util.function.*;

public class MyJVMTest_15121 {

    static String a = "f+GHg$c-Ng";

    static String b = "~~4:-vW=My";

    static int expected = 0;

    int compareTest(String a, String b, int expected) {
        int errors = 0;
        int result = Objects.compare(a, b, String.CASE_INSENSITIVE_ORDER);
        if (Integer.signum(result) != Integer.signum(expected)) {
            errors++;
            System.err.printf("When comparing %s to %s, got %d instead of %d%n.", a, b, result, expected);
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15121().compareTest(a, b, expected));
    }
}
