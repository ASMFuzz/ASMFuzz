public class MyJVMTest_7891 {

    static short[] a = { -32768, -32768, 32767, 32767, 25997, 32767, 0, -13722, 0, -32768 };

    static float[] b = { 0f, Float.NaN, Float.MAX_VALUE, 0.7752316f, 0.034367442f, Float.NaN, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE };

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
        new MyJVMTest_7891().test_vi_neg(a, b, c, d);
    }
}
