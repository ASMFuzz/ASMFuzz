public class MyJVMTest_4906 {

    static int[] a = { -971814507, 0, 4, 0, 3, 2, 0, 2076632818, 1321514992, 2 };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.7367780805542923, 0d, Double.NaN, Double.MAX_VALUE };

    static int c = 924888513;

    static double d = 0d;

    int[] test_vi(int[] a, double[] b, int c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4906().test_vi(a, b, c, d);
    }
}
