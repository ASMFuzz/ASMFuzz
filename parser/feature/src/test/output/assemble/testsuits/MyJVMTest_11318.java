public class MyJVMTest_11318 {

    static float[] a = { Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, 0f };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, 0f, 0.37292624f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.3117506f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_cp_unalndst(float[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11318().test_cp_unalndst(a, b);
    }
}
