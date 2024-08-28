public class MyJVMTest_10866 {

    static float[] a = { Float.MAX_VALUE, Float.MIN_VALUE, 0.29322904f, 0f, Float.POSITIVE_INFINITY, Float.NaN, 0.8726946f, Float.POSITIVE_INFINITY, 0f, 0.06015575f };

    static int SCALE = 2;

    float[] test_ci_scl(float[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10866().test_ci_scl(a);
    }
}
