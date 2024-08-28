public class MyJVMTest_8511 {

    static long[] a = { 0, -8807464373159629597L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 2117321696016649377L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L };

    static int SCALE = 2;

    long[] test_ci_scl(long[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8511().test_ci_scl(a);
    }
}
