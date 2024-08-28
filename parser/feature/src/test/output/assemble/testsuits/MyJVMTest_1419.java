public class MyJVMTest_1419 {

    static float[] a = { 0f, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, 0.95309114f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MIN_VALUE };

    static float[] b = { Float.POSITIVE_INFINITY, 0.5020299f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.27851713f, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_cp_alnsrc(float[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1419().test_cp_alnsrc(a, b);
    }
}
