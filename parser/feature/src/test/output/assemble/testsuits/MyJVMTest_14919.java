public class MyJVMTest_14919 {

    static short[] a = { 32767, 0, -32768, 0, 0, 32767, 32767, 0, 0, -32768 };

    static float[] b = { Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.86202484f, 0f, Float.MIN_VALUE };

    static short c = -32768;

    static float d = Float.NaN;

    short[] test_vi(short[] a, float[] b, short c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14919().test_vi(a, b, c, d);
    }
}
