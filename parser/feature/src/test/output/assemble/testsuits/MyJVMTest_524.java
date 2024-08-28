public class MyJVMTest_524 {

    static byte[] a = { -118, 44, 51, 74, -9, 35, 24, 95, 103, 116 };

    static byte[] b = { 82, 96, 52, 50, 91, -8, 5, -7, 98, -35 };

    static float[] c = { 0.91584194f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NaN };

    static float[] d = { 0.71039593f, 0.8455837f, 0.6260115f, Float.MIN_VALUE, 0.9618704f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0f };

    byte[] test_cp_neg(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_524().test_cp_neg(a, b, c, d);
    }
}
