public class MyJVMTest_9984 {

    static double[] a = { 0.22339058255021338, Double.MAX_VALUE, 0d, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.04304460943009636, Double.NaN, 0.4721020414065532, Double.NEGATIVE_INFINITY };

    static double[] b = { Double.MIN_VALUE, Double.MIN_VALUE, 0.015580852451273275, 0d, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.06257861410210752, Double.NEGATIVE_INFINITY, 0d };

    double[] test_cp_neg(double[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9984().test_cp_neg(a, b);
    }
}
