public class MyJVMTest_13185 {

    static byte[] a = { 80, -25, -99, 25, -61, -107, -86, -78, -11, 89 };

    static byte[] b = { -51, 76, -73, -21, 78, 6, -4, 62, -80, -94 };

    static float[] c = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NaN, 0.61897194f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN };

    static float[] d = { Float.MIN_VALUE, 0.029664934f, 0.3185519f, 0f, Float.NaN, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13185().test_cp_alnsrc(a, b, c, d);
    }
}
