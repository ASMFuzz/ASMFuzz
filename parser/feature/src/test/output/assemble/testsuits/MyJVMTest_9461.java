public class MyJVMTest_9461 {

    static int[] a = { 1933456580, 3, 4, 7, -692383845, 1247997550, 1, 5, 7, 0 };

    static double[] b = { 0d, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.9412094393860482, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static int c = 3;

    static double d = Double.MIN_VALUE;

    int[] test_vi_neg(int[] a, double[] b, int c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9461().test_vi_neg(a, b, c, d);
    }
}
