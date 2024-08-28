public class MyJVMTest_14256 {

    static byte[] a = { -128, -63, 46, -82, -121, 103, 98, 52, 123, -41 };

    static float[] b = { Float.POSITIVE_INFINITY, 0f, 0f, 0.49744302f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.1248458f, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN };

    static byte c = -128;

    static float d = Float.MIN_VALUE;

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
        new MyJVMTest_14256().test_vi_unaln(a, b, c, d);
    }
}
