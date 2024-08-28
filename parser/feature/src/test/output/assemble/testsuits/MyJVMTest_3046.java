import java.util.Arrays;

public class MyJVMTest_3046 {

    static long[] array = { 0, -8308811420487738180L, -5586514545192039481L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, -3100825591569295999L };

    static int n = 4;

    static long[][] arrays = { { 1L, 2L, 3L }, { 1L, 1L << 30, 1L << 50, 4L }, { 1L, Long.MAX_VALUE, Long.MIN_VALUE, 4L } };

    int checkLongArray(final long[] array, final int n) {
        if (!Arrays.equals(array, arrays[n])) {
            throw new RuntimeException("Arrays don't match: " + Arrays.toString(array) + ", " + Arrays.toString(arrays[n]));
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3046().checkLongArray(array, n);
    }
}
