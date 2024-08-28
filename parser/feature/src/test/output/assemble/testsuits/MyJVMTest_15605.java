public class MyJVMTest_15605 {

    static byte[] a = { -22, -41, 59, 104, -75, -123, -15, -11, -12, -64 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, Float.NaN, 0.7067246f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NaN };

    byte[] test_ci(byte[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15605().test_ci(a, b);
    }
}
