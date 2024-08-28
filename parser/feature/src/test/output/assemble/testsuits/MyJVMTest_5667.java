public class MyJVMTest_5667 {

    static byte[] a = { -68, -101, 34, -4, 80, 76, 115, -76, 70, 116 };

    static float[] b = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NaN };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5667().test_ci_aln(a, b);
    }
}
