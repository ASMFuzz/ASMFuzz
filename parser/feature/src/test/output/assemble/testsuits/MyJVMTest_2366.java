public class MyJVMTest_2366 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, 1215674574891842536L, 9223372036854775807L, 9223372036854775807L, -488651532878488003L, 0, 9223372036854775807L, -7000811098392151867L, 76293028964462155L };

    static long[] b = { 0, -9223372036854775808L, 64012279424349354L, 0, 5324439002052203103L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 6910051801004691452L, 9223372036854775807L };

    static int k = 6;

    int test_2ci_inv(long[] a, long[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2366().test_2ci_inv(a, b, k);
    }
}
