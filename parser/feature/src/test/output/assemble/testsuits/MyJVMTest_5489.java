public class MyJVMTest_5489 {

    static short[] a = { 0, 0, -32768, -32768, 32767, 32767, -1976, 0, -21315, 32767 };

    static float[] b = { 0f, Float.MAX_VALUE, 0f, 0.70108485f, Float.NaN, 0f, Float.MIN_VALUE, 0f, Float.NaN, Float.MAX_VALUE };

    static short c = -32768;

    static float d = 0.48647994f;

    short[] test_vi(short[] a, float[] b, short c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5489().test_vi(a, b, c, d);
    }
}
