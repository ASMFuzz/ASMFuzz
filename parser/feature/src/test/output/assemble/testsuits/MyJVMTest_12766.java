public class MyJVMTest_12766 {

    static double[] a = { Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.3193828588733554, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.17774765377794455 };

    static double b = Double.POSITIVE_INFINITY;

    static int OFFSET = 3;

    double[] test_vi_off(double[] a, double b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12766().test_vi_off(a, b);
    }
}
