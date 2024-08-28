public class MyJVMTest_12512 {

    static short[] a = { 32767, -32768, -32768, -32768, 0, 0, -20741, 32767, -32768, 0 };

    static double[] b = { 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0d, 0.5928245563749958, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    short[] test_ci_neg(short[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12512().test_ci_neg(a, b);
    }
}
