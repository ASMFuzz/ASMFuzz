public class MyJVMTest_13348 {

    static float[] a0 = { Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.3489809f, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0.37972003f };

    static float b = Float.MAX_VALUE;

    static int ITERS2 = 40000;

    float[] run_loop_with_safepoint(float[] a0, float b) {
        for (long l = 0; l < ITERS2; l++) {
            for (int i = 0; i < a0.length; i += 1) {
                a0[i] += b;
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13348().run_loop_with_safepoint(a0, b);
    }
}
