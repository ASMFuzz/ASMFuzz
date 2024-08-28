import java.util.*;
import java.util.function.*;

public class MyJVMTest_16542 {

    int testDeepEquals() {
        int errors = 0;
        Object[] values = { null, null, new byte[] { (byte) 1 }, new short[] { (short) 1 }, new int[] { 1 }, new long[] { 1L }, new char[] { (char) 1 }, new float[] { 1.0f }, new double[] { 1.0d }, new String[] { "one" } };
        values[1] = values;
        for (int i = 0; i < values.length; i++) for (int j = 0; j < values.length; j++) {
            boolean expected = (i == j);
            Object a = values[i];
            Object b = values[j];
            boolean result = Objects.deepEquals(a, b);
            if (result != expected) {
                errors++;
                System.err.printf("When equating %s to %s, got %b instead of %b%n.", a, b, result, expected);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16542().testDeepEquals());
    }
}
