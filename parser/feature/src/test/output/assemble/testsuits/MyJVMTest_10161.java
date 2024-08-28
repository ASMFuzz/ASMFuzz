public class MyJVMTest_10161 {

    static int[] a = { 3, 0, 0, 0, 0, 1842277839, 1, 0, 0, 0 };

    static int[] b = { 0, 4, 0, 5, 0, 0, 0, -510419565, 5, 1 };

    static float[] c = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NaN };

    static float[] d = { Float.MIN_VALUE, 0.7421298f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0.91672856f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    int[] test_cp(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10161().test_cp(a, b, c, d);
    }
}
