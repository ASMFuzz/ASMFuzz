public class MyJVMTest_3843 {

    static byte[] a = { 21, -115, -92, 99, 51, -108, -72, 33, -15, -110 };

    static byte[] b = { 83, -44, -46, -32, -5, 94, 20, -101, 127, 45 };

    static float[] c = { Float.MAX_VALUE, 0.54030085f, Float.MIN_VALUE, 0.523851f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0.40955085f, Float.MIN_VALUE };

    static float[] d = { 0.80608124f, Float.NaN, 0f, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.5492679f };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3843().test_cp_alnsrc(a, b, c, d);
    }
}
