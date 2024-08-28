public class MyJVMTest_12593 {

    static byte[] a = { -77, -121, -68, -87, -104, -82, 49, 54, -101, -49 };

    static float[] b = { 0.5804707f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, Float.MAX_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12593().test_ci_unaln(a, b);
    }
}
