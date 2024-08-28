public class MyJVMTest_3996 {

    static float[] a0 = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0.9868252f, 0.9864612f, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, 0f, 0f };

    static float b = 0.07391673f;

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
        new MyJVMTest_3996().run_loop_with_safepoint(a0, b);
    }
}
