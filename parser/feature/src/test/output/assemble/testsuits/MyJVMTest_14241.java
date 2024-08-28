public class MyJVMTest_14241 {

    static long[] a = { 2413406234501361643L, 0, 0, 9223372036854775807L, 9223372036854775807L, 0, 0, -2558490637738984787L, -9223372036854775808L, 0 };

    static long[] b = { -9223372036854775808L, 0, -9223372036854775808L, -8583475691816850996L, 0, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 5001630491681604340L };

    long[] test_cp_neg(long[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14241().test_cp_neg(a, b);
    }
}
