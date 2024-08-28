public class MyJVMTest_12409 {

    static double[] a = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE };

    static double b = Double.NEGATIVE_INFINITY;

    static int SCALE = 2;

    double[] test_vi_scl(double[] a, double b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12409().test_vi_scl(a, b);
    }
}
