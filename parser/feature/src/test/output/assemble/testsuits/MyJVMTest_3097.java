public class MyJVMTest_3097 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0.6037246513403569, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.7060738665485142, 0d, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE };

    static double b = Double.NEGATIVE_INFINITY;

    static int SCALE = 2;

    double[] test_vi_scl(double[] a, double b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3097().test_vi_scl(a, b);
    }
}
