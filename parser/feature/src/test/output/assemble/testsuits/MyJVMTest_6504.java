public class MyJVMTest_6504 {

    static short[] a = { 32767, 0, -32768, 32767, -32768, -32768, -32768, 0, 32767, -32666 };

    static float[] b = { 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, 0.62056386f, Float.POSITIVE_INFINITY };

    short[] test_ci_neg(short[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6504().test_ci_neg(a, b);
    }
}
