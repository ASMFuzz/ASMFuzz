public class MyJVMTest_14106 {

    static float[] a = { 0.4536808f, Float.MAX_VALUE, 0.09687054f, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.6821601f, 0.98417205f, Float.MAX_VALUE };

    static float[] b = { 0f, 0.0026552677f, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0.56725186f, 0f };

    static float c = Float.NEGATIVE_INFINITY;

    static float d = Float.NaN;

    int test_2vi_oppos(float[] a, float[] b, float c, float d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14106().test_2vi_oppos(a, b, c, d);
    }
}
