public class MyJVMTest_12911 {

    static short[] a = { 32767, 32767, 32767, -32768, -32768, 0, 0, -32768, -32768, -669 };

    static short[] b = { 0, -31704, -18417, -919, 0, 32333, -5180, 32767, 0, 32767 };

    static float[] c = { Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f };

    static float[] d = { 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN };

    short[] test_cp(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12911().test_cp(a, b, c, d);
    }
}
