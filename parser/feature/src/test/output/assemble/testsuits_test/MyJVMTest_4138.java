public class MyJVMTest_4138 {

    static int[] a = { 7, 0, 3, 9, 0, 0, 843719422, 0, 9, 0 };

    static int[] b = { 0, -1855034472, 8, 7, 1391610793, 0, 9, 1880839046, 7, 4 };

    static float[] c = { Float.MIN_VALUE, 0.17810255f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, 0f, Float.MIN_VALUE };

    static float[] d = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.NaN, 0f, Float.NEGATIVE_INFINITY, 0.36988044f, 0f, Float.NEGATIVE_INFINITY };

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
        new MyJVMTest_4138().test_cp_unalndst(a, b, c, d);
    }
}
