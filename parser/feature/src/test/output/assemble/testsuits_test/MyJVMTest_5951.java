public class MyJVMTest_5951 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, -2778044059246225405L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L };

    static int OFFSET = 3;

    long[] test_ci_off(long[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5951().test_ci_off(a);
    }
}
