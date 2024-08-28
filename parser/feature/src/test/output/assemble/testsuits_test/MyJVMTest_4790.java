public class MyJVMTest_4790 {

    static int[] a = { 291180678, 6, 3, 0, 0, 7, 0, 4, 0, 8 };

    static float[] b = { Float.MAX_VALUE, 0.5040374f, 0.47349495f, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE };

    static int c = 2021968885;

    static float d = Float.MIN_VALUE;

    int[] test_vi(int[] a, float[] b, int c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4790().test_vi(a, b, c, d);
    }
}
