public class MyJVMTest_1982 {

    static int[] a = { 0, -1901874097, 6, -1179800121, 4, 380229274, 2, 1535436610, 1189321269, 9 };

    static double[] b = { Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    int[] test_ci_aln(int[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1982().test_ci_aln(a, b);
    }
}
