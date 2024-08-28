public class MyJVMTest_9690 {

    static float[] a0 = { Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.93799937f, 0.40524518f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

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
        new MyJVMTest_9690().test_incrv(a0, b);
    }
}
