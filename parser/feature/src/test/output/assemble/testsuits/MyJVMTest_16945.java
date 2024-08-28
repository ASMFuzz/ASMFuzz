public class MyJVMTest_16945 {

    static float[] a0 = { Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.MAX_VALUE, 0.12362754f, Float.NaN, Float.POSITIVE_INFINITY };

    float[] test_init(float[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (float) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16945().test_init(a0);
    }
}
