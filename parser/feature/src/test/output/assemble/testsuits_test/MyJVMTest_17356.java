public class MyJVMTest_17356 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 2442423823033583082L, 9223372036854775807L, 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static long b = 9223372036854775807L;

    static int k = 8;

    int test_vi_inv(long[] a, long b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17356().test_vi_inv(a, b, k);
    }
}
