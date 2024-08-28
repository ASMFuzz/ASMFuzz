public class MyJVMTest_16329 {

    static int[] a = { 1, -1824280199, 9, 0, 0, 4, 9, 0, 0, 5 };

    static long[] b = { 4724036436031830310L, 9223372036854775807L, 9223372036854775807L, 3105972899158893706L, 2572478544347999213L, 870347902707880920L, 792586516109996367L, 9223372036854775807L, -6581839308716788318L, 0 };

    static int c = -439957435;

    static long d = 2899087821112218133L;

    int[] test_vi_neg(int[] a, long[] b, int c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16329().test_vi_neg(a, b, c, d);
    }
}
