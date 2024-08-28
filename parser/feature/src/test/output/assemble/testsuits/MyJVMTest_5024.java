public class MyJVMTest_5024 {

    static int[] a = { 634809525, 0, 5, 5, 0, 0, 4, -53431863, -86326078, 3 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0d, 0d, 0.3967203687184151, Double.MIN_VALUE, Double.NaN, 0d, Double.MIN_VALUE };

    static int c = 576625218;

    static double d = Double.NEGATIVE_INFINITY;

    int[] test_vi_oppos(int[] a, double[] b, int c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5024().test_vi_oppos(a, b, c, d);
    }
}
