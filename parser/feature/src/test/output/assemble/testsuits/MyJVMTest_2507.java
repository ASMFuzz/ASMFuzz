public class MyJVMTest_2507 {

    static int[] a = { 0, 5, 0, -1050921811, 9, 0, 6, 0, 0, 9 };

    static int[] b = { 0, 5, 52387375, 3, 1276728169, 0, 0, 6, 0, 0 };

    static float[] c = { Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY };

    static float[] d = { Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.65383667f, 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MAX_VALUE };

    int[] test_cp_neg(int[] a, int[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2507().test_cp_neg(a, b, c, d);
    }
}
