public class MyJVMTest_1866 {

    static int[] a = { 0, 567259521, 5, 4, 1, 2, 0, -638732277, 5, 250267383 };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, 0.4606428337121783, Double.MIN_VALUE, Double.NaN, 0.2538164435830027, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    int[] test_ci_oppos(int[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1866().test_ci_oppos(a, b);
    }
}
