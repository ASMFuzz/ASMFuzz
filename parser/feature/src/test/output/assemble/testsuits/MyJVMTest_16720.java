public class MyJVMTest_16720 {

    static byte[] a = { 106, -8, -80, 34, -121, -44, 84, 40, -15, -22 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0.4125641f, 0.53255916f, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static byte c = -128;

    static float d = Float.MAX_VALUE;

    byte[] test_vi_oppos(byte[] a, float[] b, byte c, float d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16720().test_vi_oppos(a, b, c, d);
    }
}
