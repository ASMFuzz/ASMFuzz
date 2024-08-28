public class MyJVMTest_527 {

    static float[] a0 = { Float.NEGATIVE_INFINITY, 0.7757122f, Float.POSITIVE_INFINITY, 0f, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f };

    static float b = Float.MIN_VALUE;

    static int ITERS = 5000;

    static int SFP_ITERS = 10000;

    float[] test_incrv(float[] a0, float b) {
        for (long l = 0; l < SFP_ITERS; l++) {
            for (int i = 0; i < a0.length; i += 1) {
                a0[i] += b;
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_527().test_incrv(a0, b);
    }
}
