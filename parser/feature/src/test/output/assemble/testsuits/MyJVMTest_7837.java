public class MyJVMTest_7837 {

    static byte[] a = { -47, -83, 97, -52, -41, -53, -93, 57, 3, -35 };

    static float[] b = { 0f, 0.45538062f, 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN };

    static byte c = 127;

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
        new MyJVMTest_7837().test_vi_aln(a, b, c, d);
    }
}
