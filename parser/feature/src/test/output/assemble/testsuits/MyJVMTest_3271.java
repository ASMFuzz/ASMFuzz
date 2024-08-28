public class MyJVMTest_3271 {

    static byte[] a = { -113, -36, 28, 91, 115, -60, 36, -126, -52, -101 };

    static float[] b = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, 0f, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, Float.NaN, 0.60742587f, 0.653024f };

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
        new MyJVMTest_3271().test_ci_unaln(a, b);
    }
}
