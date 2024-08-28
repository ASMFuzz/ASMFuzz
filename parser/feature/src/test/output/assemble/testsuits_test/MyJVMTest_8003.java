public class MyJVMTest_8003 {

    static long[] a = { 0, 9223372036854775807L, 9223372036854775807L, 0, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -7727235361941163916L };

    static long[] b = { -9223372036854775808L, -5495577224108986465L, 0, 0, 7030254922653934701L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -1956509475242291977L, -2266406086042524512L };

    static int k = 0;

    int test_cp_inv(long[] a, long[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8003().test_cp_inv(a, b, k);
    }
}
