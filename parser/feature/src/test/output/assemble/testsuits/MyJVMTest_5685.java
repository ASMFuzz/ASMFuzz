import java.util.*;
import java.util.function.*;

public class MyJVMTest_5685 {

    static String a = "n{]v-GyI?+";

    static String b = "\\YA;*ijX-[";

    static int expected = 716132340;

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
        System.out.println(new MyJVMTest_5685().compareTest(a, b, expected));
    }
}
