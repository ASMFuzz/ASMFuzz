public class MyJVMTest_10334 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NaN, Float.POSITIVE_INFINITY, 0.37417823f, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float c = Float.NEGATIVE_INFINITY;

    static float d = Float.MIN_VALUE;

    static int OFFSET = 3;

    float[] test_2vi_off(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10334().test_2vi_off(a, b, c, d);
    }
}
