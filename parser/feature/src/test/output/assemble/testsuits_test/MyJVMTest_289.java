public class MyJVMTest_289 {

    static float[] a = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, 0f, 0.23788679f, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN };

    static float[] c = { 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0f, 0.16650182f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] d = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, 0.48121852f, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN };

    static float total = 0.92659986f;

    float sumReductionImplement(float[] a, float[] b, float[] c, float[] d, float total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_289().sumReductionImplement(a, b, c, d, total));
    }
}
