import java.util.*;
import java.util.function.*;

public class MyJVMTest_11836 {

    int compareTest(String a, String b, int expected) {
        int errors = 0;
        int result = Objects.compare(a, b, String.CASE_INSENSITIVE_ORDER);
        if (Integer.signum(result) != Integer.signum(expected)) {
            errors++;
            System.err.printf("When comparing %s to %s, got %d instead of %d%n.", a, b, result, expected);
        }
        return errors;
    }

    int testCompare() {
        int errors = 0;
        String[] values = { "e. e. cummings", "zzz" };
        String[] VALUES = { "E. E. Cummings", "ZZZ" };
        errors += compareTest(null, null, 0);
        for (int i = 0; i < values.length; i++) {
            String a = values[i];
            errors += compareTest(a, a, 0);
            for (int j = 0; j < VALUES.length; j++) {
                int expected = Integer.compare(i, j);
                String b = VALUES[j];
                errors += compareTest(a, b, expected);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11836().testCompare());
    }
}
