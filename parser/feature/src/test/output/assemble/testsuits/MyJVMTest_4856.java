public class MyJVMTest_4856 {

    static byte[] a = { 76, 106, 107, -102, 68, 100, 58, 34, 34, 118 };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.97625023f, Float.NaN };

    static byte c = -128;

    static float d = Float.NaN;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, float[] b, byte c, float d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4856().test_vi_unaln(a, b, c, d);
    }
}
