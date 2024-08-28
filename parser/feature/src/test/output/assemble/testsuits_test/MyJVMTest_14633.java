public class MyJVMTest_14633 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.5439783f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.NaN };

    static float b = Float.POSITIVE_INFINITY;

    static int SCALE = 2;

    float[] test_vi_scl(float[] a, float b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14633().test_vi_scl(a, b);
    }
}
