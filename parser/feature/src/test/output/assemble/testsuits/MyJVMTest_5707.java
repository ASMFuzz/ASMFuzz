public class MyJVMTest_5707 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NaN, 0.3583085f, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] b = { 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0.87095296f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_cp_alndst(float[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5707().test_cp_alndst(a, b);
    }
}
