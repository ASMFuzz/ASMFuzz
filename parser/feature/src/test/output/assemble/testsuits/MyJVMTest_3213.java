public class MyJVMTest_3213 {

    static short[] a = { -8505, 0, 20454, 32767, 32767, -32768, -29244, -1899, -25491, 32767 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE };

    short[] test_ci(short[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3213().test_ci(a, b);
    }
}
