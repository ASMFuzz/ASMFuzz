public class MyJVMTest_5044 {

    static double[] a = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.3388798257168705, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.NaN, 0d, Double.MAX_VALUE, Double.MAX_VALUE };

    static double b = Double.POSITIVE_INFINITY;

    int test_vi_oppos(double[] a, double b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5044().test_vi_oppos(a, b);
    }
}
