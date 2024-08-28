public class MyJVMTest_2705 {

    static byte[] a = { -76, -22, 25, 107, -66, 122, -110, -116, 15, 118 };

    static byte[] b = { 3, 52, -103, -125, 2, -22, 100, -116, 89, -53 };

    static float[] c = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] d = { 0.5130803f, Float.NEGATIVE_INFINITY, 0.36148864f, 0f, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NaN };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2705().test_cp_unalnsrc(a, b, c, d);
    }
}
