public class MyJVMTest_14359 {

    static float[] a0 = { Float.MAX_VALUE, Float.MAX_VALUE, 0.024793148f, 0f, Float.NaN, Float.NaN, 0f, Float.MAX_VALUE, 0f, 0.55187136f };

    static float[] a1 = { Float.NaN, 0.6595662f, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE };

    float[] test_addi(float[] a0, float[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] + (float) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14359().test_addi(a0, a1);
    }
}
