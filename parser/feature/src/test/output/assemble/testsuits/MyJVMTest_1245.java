public class MyJVMTest_1245 {

    static double[] a = { 0.46438624728920463, Double.MIN_VALUE, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.NaN };

    static double[] b = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, 0.5988968303849116, Double.NEGATIVE_INFINITY, Double.NaN, 0.32676728341596895, Double.NaN, Double.MIN_VALUE };

    static int ALIGN_OFF = 8;

    double[] test_cp_alndst(double[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1245().test_cp_alndst(a, b);
    }
}
