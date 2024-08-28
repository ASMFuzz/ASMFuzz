public class MyJVMTest_15968 {

    static byte[] a = { 15, 76, -35, -80, 59, -16, 100, -6, 62, 75 };

    static float[] b = { Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0.010066748f, 0.87546f, Float.MIN_VALUE, Float.MAX_VALUE, 0f, 0.24765229f, 0.2266419f };

    static byte c = -33;

    static float d = Float.POSITIVE_INFINITY;

    byte[] test_vi_neg(byte[] a, float[] b, byte c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15968().test_vi_neg(a, b, c, d);
    }
}
