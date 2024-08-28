public class MyJVMTest_5595 {

    static int[] a = { 0, 0, 0, -1495390853, 1, 0, 1, 0, 5, 4 };

    static int[] b = { 6, 4, 5, 0, 4, 0, 1, 2, 4, 2 };

    static float[] c = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NaN, 0f, Float.NEGATIVE_INFINITY, 0.1501782f, Float.NaN };

    static float[] d = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.45994782f, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5595().test_cp_alndst(a, b, c, d);
    }
}
