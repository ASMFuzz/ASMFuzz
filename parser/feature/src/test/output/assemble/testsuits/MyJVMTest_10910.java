public class MyJVMTest_10910 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, 0.47530300863742736, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] b = { Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0d, 0.3436357493169456, 0.32352814244903394, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d };

    static int SCALE = 2;

    double[] test_cp_scl(double[] a, double[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10910().test_cp_scl(a, b);
    }
}
