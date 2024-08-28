public class MyJVMTest_9503 {

    static float[] a = { Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0.9232418f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0f };

    static float[] b = { Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0.0137473345f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_2ci_unaln(float[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9503().test_2ci_unaln(a, b);
    }
}
