public class MyJVMTest_7203 {

    static byte[] a = { 35, -84, 39, -117, -64, 76, -16, -115, 90, 19 };

    static float[] b = { Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, 0.5510354f, 0.41509253f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    byte[] test_ci_oppos(byte[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7203().test_ci_oppos(a, b);
    }
}
