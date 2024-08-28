public class MyJVMTest_4709 {

    static float[] a = { Float.NaN, 0.99659884f, 0.52418834f, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.18568581f };

    static float[] b = { 0f, Float.MIN_VALUE, 0.6732623f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, 0f, 0f, 0.467721f };

    static float c = Float.NEGATIVE_INFINITY;

    static float d = 0f;

    int test_2vi_oppos(float[] a, float[] b, float c, float d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4709().test_2vi_oppos(a, b, c, d);
    }
}
