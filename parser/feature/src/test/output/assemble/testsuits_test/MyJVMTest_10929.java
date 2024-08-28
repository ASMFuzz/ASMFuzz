public class MyJVMTest_10929 {

    static float[] a = { Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.9831632f, 0.25176084f, 0.6905394f, Float.MIN_VALUE, 0f, 0.06889224f };

    static int OFFSET = 3;

    float[] test_ci_off(float[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10929().test_ci_off(a);
    }
}
