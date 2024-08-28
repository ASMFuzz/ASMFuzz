public class MyJVMTest_17583 {

    static float[] a = { Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.9725772f, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE };

    static float[] b = { Float.MIN_VALUE, 0.090373635f, 0.58452094f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, 0.14568001f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] c = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0.52949965f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.13522893f };

    static float[] d = { 0f, 0f, 0f, Float.NEGATIVE_INFINITY, 0.8756724f, Float.NaN, Float.POSITIVE_INFINITY, 0.9618615f, Float.NaN, Float.MAX_VALUE };

    static float total = Float.NEGATIVE_INFINITY;

    float sumReductionImplement(float[] a, float[] b, float[] c, float[] d, float total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = Math.abs(-a[i] * -b[i]) + Math.abs(-a[i] * -c[i]) + Math.abs(-b[i] * -c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17583().sumReductionImplement(a, b, c, d, total));
    }
}
