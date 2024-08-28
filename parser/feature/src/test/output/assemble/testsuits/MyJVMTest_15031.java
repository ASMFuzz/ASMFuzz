public class MyJVMTest_15031 {

    static int[] a = { 1093375184, 2, 0, 6, -712928774, 4, -1930565411, -963536374, -1380990323, 5 };

    static int[] b = { -290584744, 3, -746193811, 4, 0, 4, -1042585222, -709801325, 0, 7 };

    static float[] c = { 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.NaN, 0f };

    static float[] d = { Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15031().test_cp_alndst(a, b, c, d);
    }
}
