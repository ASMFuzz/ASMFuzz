public class MyJVMTest_3576 {

    static short[] a = { 8123, -15686, 32767, -32768, 0, 32767, 32767, 32767, 0, 32767 };

    static short[] b = { -11072, -32768, -32768, -32768, -12407, 8160, 0, 32767, 20356, 0 };

    static float[] c = { 0.6075074f, 0f, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, 0f };

    static float[] d = { Float.MAX_VALUE, 0.2065311f, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.22158384f, Float.POSITIVE_INFINITY, 0.9883362f, 0f };

    short[] test_cp(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3576().test_cp(a, b, c, d);
    }
}
