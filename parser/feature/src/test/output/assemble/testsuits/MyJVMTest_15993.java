public class MyJVMTest_15993 {

    static short[] a = { -32768, -32768, 0, -32768, 32767, 0, 0, 32767, -32768, -32768 };

    static float[] b = { 0.8479605f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.12324321f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.91179883f, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

    short[] test_ci_neg(short[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15993().test_ci_neg(a, b);
    }
}
