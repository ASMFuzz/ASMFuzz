public class MyJVMTest_17453 {

    static short[] a = { 0, 32767, 32767, -32768, 0, 32767, -32768, 32767, 32767, 0 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0.3855527f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static short c = 0;

    static float d = Float.MAX_VALUE;

    short[] test_vi_neg(short[] a, float[] b, short c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17453().test_vi_neg(a, b, c, d);
    }
}
