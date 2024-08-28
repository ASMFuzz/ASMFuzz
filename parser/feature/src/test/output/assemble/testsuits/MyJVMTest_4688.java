public class MyJVMTest_4688 {

    static float[] a = { 0.049263835f, Float.NaN, Float.NaN, 0.4863869f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    static float[] b = { 0.9127761f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.MAX_VALUE };

    static int SCALE = 2;

    float[] test_2ci_scl(float[] a, float[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.f;
            b[i * SCALE] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4688().test_2ci_scl(a, b);
    }
}
