public class MyJVMTest_7944 {

    static float[] a = { Float.NEGATIVE_INFINITY, 0f, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0.8393903f, Float.NaN };

    static int SCALE = 2;

    float[] test_cp_scl(float[] a, float[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7944().test_cp_scl(a, b);
    }
}
