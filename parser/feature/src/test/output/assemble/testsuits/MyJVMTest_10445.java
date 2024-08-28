public class MyJVMTest_10445 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0d, 0d, Double.NaN, 0d, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE };

    static double[] b = { Double.NaN, 0.10208033834403851, Double.NaN, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, 0.4575930043825265 };

    static int ALIGN_OFF = 8;

    double[] test_cp_alndst(double[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10445().test_cp_alndst(a, b);
    }
}
