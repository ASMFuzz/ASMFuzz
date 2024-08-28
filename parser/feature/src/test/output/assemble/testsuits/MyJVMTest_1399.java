public class MyJVMTest_1399 {

    static byte[] a = { -65, 93, 35, 70, 97, -116, 77, 90, -50, -20 };

    static byte[] b = { -29, -72, -67, 68, -35, 125, -75, 40, 47, -67 };

    static float[] c = { 0.036120057f, 0.004936278f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0f };

    static float[] d = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.6284916f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.8550679f, Float.POSITIVE_INFINITY, Float.NaN };

    byte[] test_cp(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1399().test_cp(a, b, c, d);
    }
}
