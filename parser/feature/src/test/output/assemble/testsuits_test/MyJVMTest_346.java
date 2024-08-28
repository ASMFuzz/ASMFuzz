public class MyJVMTest_346 {

    static float[] a = { 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.15864456f, 0.54509395f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.41662818f };

    static float[] b = { Float.MAX_VALUE, Float.MAX_VALUE, 0.22856891f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY };

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
        new MyJVMTest_346().test_2ci_unaln(a, b);
    }
}
