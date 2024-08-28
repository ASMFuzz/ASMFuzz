public class MyJVMTest_16107 {

    static float[] a0 = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] a1 = { Float.NaN, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NaN, 0f, Float.NEGATIVE_INFINITY, 0f };

    static float b = Float.NaN;

    static int ITERS = 5000;

    static int SFP_ITERS = 10000;

    float[] test_addv(float[] a0, float[] a1, float b) {
        for (long l = 0; l < SFP_ITERS; l++) {
            for (int i = 0; i < a0.length; i += 1) {
                a0[i] += a1[i] + b;
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16107().test_addv(a0, a1, b);
    }
}
