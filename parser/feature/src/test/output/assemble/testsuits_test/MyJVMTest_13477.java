public class MyJVMTest_13477 {

    static float[] a = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.35618168f, 0f, 0.25029308f, 0.88235056f, Float.NEGATIVE_INFINITY, 0.29813254f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.NEGATIVE_INFINITY, 0.45214605f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_cp_unalnsrc(float[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13477().test_cp_unalnsrc(a, b);
    }
}
