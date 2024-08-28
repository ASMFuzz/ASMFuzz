public class MyJVMTest_16882 {

    static long[] a = { 0, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -3843218586456358226L, 0 };

    static long b = -9223372036854775808L;

    static int OFFSET = 3;

    long[] test_vi_off(long[] a, long b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16882().test_vi_off(a, b);
    }
}
