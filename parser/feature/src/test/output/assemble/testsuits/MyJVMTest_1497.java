import java.util.Arrays;

public class MyJVMTest_1497 {

    static int n = 2;

    static long[][] arrays = { { 1L, 2L, 3L }, { 1L, 1L << 30, 1L << 50, 4L }, { 1L, Long.MAX_VALUE, Long.MIN_VALUE, 4L } };

    long[] getLongArray(final int n) {
        return arrays[n];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1497().getLongArray(n)));
    }
}
