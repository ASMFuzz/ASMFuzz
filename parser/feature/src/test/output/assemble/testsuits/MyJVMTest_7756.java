public class MyJVMTest_7756 {

    static double[] a = { Double.MIN_VALUE, 0.9836611958216641, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0.804936534035612, 0.6978723682985801 };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.07384277597176181, Double.NaN, Double.MAX_VALUE };

    static double c = Double.POSITIVE_INFINITY;

    static double d = Double.POSITIVE_INFINITY;

    int test_2vi_oppos(double[] a, double[] b, double c, double d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7756().test_2vi_oppos(a, b, c, d);
    }
}
