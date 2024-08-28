public class MyJVMTest_6611 {

    static float[] a0 = { 0.87882656f, 0f, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0.65248036f };

    static float[] a1 = { Float.NaN, 0f, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY };

    static float b = Float.MAX_VALUE;

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
        new MyJVMTest_6611().test_addv(a0, a1, b);
    }
}
