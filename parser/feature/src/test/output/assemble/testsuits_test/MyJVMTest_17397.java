public class MyJVMTest_17397 {

    static byte[] a = { -5, -112, 119, 105, 106, 4, -35, -16, -66, 24 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, 0f, 0.47273058f };

    static byte c = 0;

    static float d = Float.NEGATIVE_INFINITY;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, float[] b, byte c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17397().test_vi_aln(a, b, c, d);
    }
}
