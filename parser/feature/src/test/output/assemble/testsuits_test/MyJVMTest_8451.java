public class MyJVMTest_8451 {

    static double[] a = { 0d, 0.41125699855873754, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NaN, 0.7736351043112514, Double.NEGATIVE_INFINITY, 0d, 0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY };

    static double c = Double.POSITIVE_INFINITY;

    static double d = Double.NaN;

    static int SCALE = 2;

    double[] test_2vi_scl(double[] a, double[] b, double c, double d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8451().test_2vi_scl(a, b, c, d);
    }
}
