public class MyJVMTest_9687 {

    static byte[] a = { 2, -90, -105, 39, 20, -108, -89, 113, 109, 96 };

    static byte[] b = { -72, 30, -121, 61, 95, 86, -10, 68, -44, 21 };

    static float[] c = { 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0f, 0.15426755f, 0f, Float.MIN_VALUE, Float.NaN };

    static float[] d = { Float.NEGATIVE_INFINITY, 0.43205363f, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, 0f, 0.7420353f, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY };

    byte[] test_cp_neg(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9687().test_cp_neg(a, b, c, d);
    }
}
