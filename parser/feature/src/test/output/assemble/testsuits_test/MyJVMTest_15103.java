public class MyJVMTest_15103 {

    static byte[] a = { -110, -93, -65, -35, 55, -99, -55, 87, 12, 85 };

    static float[] b = { 0.30557954f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15103().test_ci_aln(a, b);
    }
}
