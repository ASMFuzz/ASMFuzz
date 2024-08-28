public class MyJVMTest_6136 {

    static byte[] a = { 4, 122, -41, 36, -108, 50, 18, 48, 4, -96 };

    static float[] b = { 0.30986667f, Float.MIN_VALUE, 0.94798857f, Float.MAX_VALUE, 0.1809532f, Float.NaN, Float.MAX_VALUE, 0f, 0.61204135f, Float.NEGATIVE_INFINITY };

    byte[] test_ci(byte[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6136().test_ci(a, b);
    }
}
