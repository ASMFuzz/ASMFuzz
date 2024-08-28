public class MyJVMTest_17295 {

    static long[] a = { 5223898066470771257L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 0, 0, 0, 4192249259962467151L };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NaN, 0.27869375216196557, Double.MAX_VALUE, Double.MAX_VALUE, 0.7478417998292799, 0.09271296333581203, 0d, Double.NaN, Double.NaN };

    long[] test_ci(long[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17295().test_ci(a, b);
    }
}
