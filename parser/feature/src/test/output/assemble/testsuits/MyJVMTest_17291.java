public class MyJVMTest_17291 {

    static long[] a = { 9223372036854775807L, 0, -9223372036854775808L, 6203508943807370807L, 9223372036854775807L, 9223372036854775807L, 2029510924625810621L, -4979532700290972033L, -9223372036854775808L, 0 };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, 0, -9027683003394752482L, 9223372036854775807L, 3033913048952549941L, 0, -7420779431414701853L, 9223372036854775807L, 9223372036854775807L };

    static int OFFSET = 3;

    long[] test_2ci_off(long[] a, long[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17291().test_2ci_off(a, b);
    }
}
