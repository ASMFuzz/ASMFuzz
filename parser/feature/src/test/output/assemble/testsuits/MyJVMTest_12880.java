public class MyJVMTest_12880 {

    static double[] a = { 0.9936699008778782, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, 0.4523443070039793, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN };

    static double[] b = { Double.MAX_VALUE, Double.MIN_VALUE, 0.036081138195657836, Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, Double.NaN, 0d };

    double[] test_cp(double[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12880().test_cp(a, b);
    }
}
