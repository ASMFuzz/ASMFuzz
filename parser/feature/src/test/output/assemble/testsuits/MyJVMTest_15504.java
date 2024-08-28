public class MyJVMTest_15504 {

    static double[] a = { Double.MIN_VALUE, 0d, 0.5188639635369933, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE };

    static int OFFSET = 3;

    double[] test_2ci_off(double[] a, double[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.;
            b[i + OFFSET] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15504().test_2ci_off(a, b);
    }
}
