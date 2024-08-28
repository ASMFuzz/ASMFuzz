public class MyJVMTest_7197 {

    static byte[] a = { -79, -42, 117, 1, 15, 54, -107, 37, 109, -76 };

    static float[] b = { Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, 0.99477f, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static byte c = 127;

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
        new MyJVMTest_7197().test_vi_oppos(a, b, c, d);
    }
}
