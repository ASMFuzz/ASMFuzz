public class MyJVMTest_11566 {

    static byte[] a = { -116, -8, 96, -65, 104, -110, 66, -76, -40, 34 };

    static byte[] b = { 45, -47, 50, 14, 70, -23, 36, -47, -66, 26 };

    static float[] c = { 0.7863805f, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float[] d = { 0.5016586f, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.8887946f, 0.8593741f, 0f, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11566().test_cp_alndst(a, b, c, d);
    }
}
