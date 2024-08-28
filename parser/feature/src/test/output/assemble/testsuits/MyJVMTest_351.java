public class MyJVMTest_351 {

    static long[] a = { -9223372036854775808L, 372064970776829029L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L };

    static long[] b = { 0, 0, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 1890310523030158233L, 9223372036854775807L };

    static long c = 9223372036854775807L;

    static long d = 0;

    static int OFFSET = 3;

    long[] test_2vi_off(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_351().test_2vi_off(a, b, c, d);
    }
}
