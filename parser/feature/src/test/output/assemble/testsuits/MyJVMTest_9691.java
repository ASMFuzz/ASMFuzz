public class MyJVMTest_9691 {

    static long[] a = { 0, 9223372036854775807L, 0, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 0 };

    static int k = 6;

    int test_ci_inv(long[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9691().test_ci_inv(a, k);
    }
}
