public class MyJVMTest_3195 {

    static short[] a = { 0, -32768, 28790, -32768, 0, -9055, -32768, 10182, -24514, -12697 };

    static double[] b = { Double.POSITIVE_INFINITY, 0.7331224915759716, Double.POSITIVE_INFINITY, 0d, 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    short[] test_ci_neg(short[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3195().test_ci_neg(a, b);
    }
}
