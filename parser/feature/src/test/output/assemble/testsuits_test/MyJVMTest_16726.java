public class MyJVMTest_16726 {

    static byte[] a = { 11, -100, -91, 10, -21, 117, 32, -108, 127, -14 };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, 0.89334273f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    byte[] test_ci_oppos(byte[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16726().test_ci_oppos(a, b);
    }
}
