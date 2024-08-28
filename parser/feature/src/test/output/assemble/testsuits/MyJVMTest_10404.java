public class MyJVMTest_10404 {

    static float[] a0 = { Float.MAX_VALUE, Float.NaN, Float.NaN, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE };

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
        new MyJVMTest_10404().test_incrc(a0);
    }
}
