public class MyJVMTest_10632 {

    static float[] a = { Float.NaN, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f };

    static float[] b = { 0.005583763f, Float.POSITIVE_INFINITY, Float.NaN, 0.6911767f, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NaN, 0.0855031f, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_cp_alnsrc(float[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10632().test_cp_alnsrc(a, b);
    }
}
