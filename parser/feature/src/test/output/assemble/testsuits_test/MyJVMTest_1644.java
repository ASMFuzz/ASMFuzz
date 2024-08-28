public class MyJVMTest_1644 {

    static float[] a = { Float.NaN, Float.NaN, Float.MIN_VALUE, 0.19205487f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.34118629f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static int SCALE = 2;

    float[] test_ci_scl(float[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1644().test_ci_scl(a);
    }
}
