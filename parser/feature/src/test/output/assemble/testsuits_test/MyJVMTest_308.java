public class MyJVMTest_308 {

    static int[] a = { 0, 0, 382743533, -1114547781, 3, 4, -106755036, 2, -656595088, 0 };

    static double[] b = { 0.6552159064973637, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE };

    static int c = -1189942370;

    static double d = 0.2773966729362719;

    int[] test_vi_neg(int[] a, double[] b, int c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_308().test_vi_neg(a, b, c, d);
    }
}
