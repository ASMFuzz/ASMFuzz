public class MyJVMTest_1204 {

    static float[] a0 = { 0.38565975f, 0f, Float.MIN_VALUE, 0.75408965f, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static int ITERS = 5000;

    static int SFP_ITERS = 10000;

    static float VALUE = 15.f;

    float[] test_incrc(float[] a0) {
        for (long l = 0; l < SFP_ITERS; l++) {
            for (int i = 0; i < a0.length; i += 1) {
                a0[i] += VALUE;
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1204().test_incrc(a0);
    }
}
