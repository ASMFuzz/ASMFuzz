public class MyJVMTest_2072 {

    static float[] a = { 0.1402359f, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MIN_VALUE, 0f, 0.22946715f, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    static float[] b = { Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_cp_unalndst(float[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2072().test_cp_unalndst(a, b);
    }
}
