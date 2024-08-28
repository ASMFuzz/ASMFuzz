public class MyJVMTest_2686 {

    static int[] a = { 0, 0, 2, 0, 1332801714, 1238392268, 3, 0, 0, -936729614 };

    static double[] b = { Double.NEGATIVE_INFINITY, 0.018968475265165097, Double.MIN_VALUE, Double.MIN_VALUE, 0.48148199801824587, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY };

    int[] test_ci_neg(int[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2686().test_ci_neg(a, b);
    }
}
