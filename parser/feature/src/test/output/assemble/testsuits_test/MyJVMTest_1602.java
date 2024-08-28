public class MyJVMTest_1602 {

    static short[] a = { 32767, 32767, 0, 16502, -9936, -32768, -6996, 32767, 32767, -32768 };

    static float[] b = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE };

    short[] test_ci_oppos(short[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1602().test_ci_oppos(a, b);
    }
}
