public class MyJVMTest_17507 {

    static float[] a = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, 0.7402968f, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.MAX_VALUE, 0.38303405f };

    static float[] b = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static int SCALE = 2;

    float[] test_cp_scl(float[] a, float[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17507().test_cp_scl(a, b);
    }
}
