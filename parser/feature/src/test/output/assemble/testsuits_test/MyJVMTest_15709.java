public class MyJVMTest_15709 {

    static float[] a0 = { 0.83588654f, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.57220864f, Float.NaN, Float.MIN_VALUE };

    static float[] a1 = { Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

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
        new MyJVMTest_15709().test_addc(a0, a1);
    }
}
