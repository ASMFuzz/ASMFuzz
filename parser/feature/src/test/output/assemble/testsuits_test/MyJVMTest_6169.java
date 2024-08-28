public class MyJVMTest_6169 {

    static float[] a = { 0.019955397f, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.41384816f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] b = { Float.MIN_VALUE, 0.49822044f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE };

    static float[] c = { Float.NaN, 0.45339686f, Float.NaN, 0.45623362f, Float.MAX_VALUE, 0f, 0.1972844f, 0.7205706f, 0f, Float.NEGATIVE_INFINITY };

    float[] sumReductionInit(float[] a, float[] b, float[] c) {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i * 1 + j;
                b[i] = i * 1 - j;
                c[i] = i + j;
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6169().sumReductionInit(a, b, c);
    }
}
