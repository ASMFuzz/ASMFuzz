public class MyJVMTest_15147 {

    static float[] a = { Float.NaN, Float.NaN, 0.7324032f, Float.MAX_VALUE, 0.19850993f, Float.NEGATIVE_INFINITY, 0f, 0.6844374f, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0.015012562f, Float.MIN_VALUE, 0.772462f };

    static int ALIGN_OFF = 8;

    float[] test_cp_alndst(float[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15147().test_cp_alndst(a, b);
    }
}
