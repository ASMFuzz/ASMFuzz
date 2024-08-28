public class MyJVMTest_14306 {

    static int[] a = { 2, 8, -1168217264, 0, 0, 3, 4, 0, 3, 0 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d };

    static int c = 0;

    static double d = Double.POSITIVE_INFINITY;

    int[] test_vi(int[] a, double[] b, int c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14306().test_vi(a, b, c, d);
    }
}
