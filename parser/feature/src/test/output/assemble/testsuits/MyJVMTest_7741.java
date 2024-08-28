public class MyJVMTest_7741 {

    static long[] a = { -2846415664496599368L, 9223372036854775807L, 0, -9223372036854775808L, -537219360893352798L, -2737560125870315880L, -9223372036854775808L, 9223372036854775807L, 0, 2684149364740305472L };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, 0.8099506370795351, 0.4915984224250364, Double.NEGATIVE_INFINITY, 0.4140681502071941, 0d, 0.5946034516010358, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    long[] test_ci(long[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7741().test_ci(a, b);
    }
}
