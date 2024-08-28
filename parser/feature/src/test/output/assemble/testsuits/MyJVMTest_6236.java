public class MyJVMTest_6236 {

    static float[] a0 = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0.19298708f, Float.NaN };

    static float[] a1 = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY };

    static int ITERS = 5000;

    static int SFP_ITERS = 10000;

    static float VALUE = 15.f;

    float[] test_addc(float[] a0, float[] a1) {
        for (long l = 0; l < SFP_ITERS; l++) {
            for (int i = 0; i < a0.length; i += 1) {
                a0[i] += a1[i] + VALUE;
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6236().test_addc(a0, a1);
    }
}
