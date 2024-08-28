public class MyJVMTest_13499 {

    static int[] a = { -40039442, 752275043, 8, -1692915791, 2, 1, 0, 0, 2, 325546047 };

    static int[] b = { 8, 0, 0, 1052668253, 0, -1273466243, 0, 0, 4, -2104110047 };

    static float[] c = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] d = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.025253117f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, 0.07521379f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalndst(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13499().test_cp_unalndst(a, b, c, d);
    }
}
