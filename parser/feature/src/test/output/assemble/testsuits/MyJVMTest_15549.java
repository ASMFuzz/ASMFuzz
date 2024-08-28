public class MyJVMTest_15549 {

    static double[] a0 = { Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0.12353674245336499, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN };

    double[] test_init(double[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (double) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15549().test_init(a0);
    }
}
