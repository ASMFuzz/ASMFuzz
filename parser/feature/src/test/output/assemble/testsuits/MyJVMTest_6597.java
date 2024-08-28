public class MyJVMTest_6597 {

    static byte[] a = { 107, 76, 124, -58, 32, -59, -59, -26, -74, 30 };

    static byte[] b = { -68, 34, 39, 105, -84, 101, 118, -49, -96, -113 };

    static float[] c = { Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static float[] d = { 0.3425566f, Float.MAX_VALUE, 0.9847223f, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY };

    byte[] test_cp_oppos(byte[] a, byte[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6597().test_cp_oppos(a, b, c, d);
    }
}
