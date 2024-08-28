public class MyJVMTest_17395 {

    static double[] a = { 0d, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.MIN_VALUE, 0d, 0d, 0.08046618293318508 };

    static int SCALE = 2;

    double[] test_ci_scl(double[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17395().test_ci_scl(a);
    }
}
