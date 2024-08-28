public class MyJVMTest_10610 {

    static byte[] a = { -67, 89, 111, -46, 62, 51, 59, 31, -99, -118 };

    static byte[] b = { 37, 6, -12, -21, 49, -19, -104, -31, 104, 67 };

    static float[] c = { Float.NaN, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NaN };

    static float[] d = { 0.8582894f, 0.9733559f, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.5322044f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE };

    byte[] test_cp(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10610().test_cp(a, b, c, d);
    }
}
