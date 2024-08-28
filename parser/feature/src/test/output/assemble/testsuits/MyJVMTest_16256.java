import java.util.*;
import java.util.function.*;

public class MyJVMTest_16256 {

    int testEquals() {
        int errors = 0;
        Object[] values = { null, "42", 42 };
        for (int i = 0; i < values.length; i++) for (int j = 0; j < values.length; j++) {
            boolean expected = (i == j);
            Object a = values[i];
            Object b = values[j];
            boolean result = Objects.equals(a, b);
            if (result != expected) {
                errors++;
                System.err.printf("When equating %s to %s, got %b instead of %b%n.", a, b, result, expected);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16256().testEquals());
    }
}
