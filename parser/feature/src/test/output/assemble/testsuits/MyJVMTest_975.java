public class MyJVMTest_975 {

    static int[] a = { 0, 5, 5, 1, -912209996, 3, 0, 0, 0, 7 };

    static int[] b = { 3, 7, 3, -927893715, 1309557914, 4, 8, 0, 2, 7 };

    static float[] c = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0.47669756f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.27677298f, Float.MIN_VALUE, Float.NaN, Float.NaN };

    static float[] d = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.7909817f, 0.805071f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN };

    int[] test_cp(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_975().test_cp(a, b, c, d);
    }
}
