public class MyJVMTest_17938 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.21408802f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.52707404f, Float.MAX_VALUE };

    static float c = Float.MAX_VALUE;

    static float d = 0.3723033f;

    float[] test_2vi(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17938().test_2vi(a, b, c, d);
    }
}
