public class MyJVMTest_8016 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0f, Float.MIN_VALUE };

    static float[] b = { 0.05707532f, 0.8189317f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.87794805f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] c = { Float.POSITIVE_INFINITY, 0.08045435f, 0.16358143f, 0.5038065f, Float.NEGATIVE_INFINITY, 0.98072755f, 0f, 0.9324095f, 0.062346756f, Float.MAX_VALUE };

    static float[] d = { 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0.23335826f, Float.POSITIVE_INFINITY, 0.081097364f, Float.NaN, 0.9076745f, 0.9853606f };

    static float total = Float.NaN;

    float sumReductionImplement(float[] a, float[] b, float[] c, float[] d, float total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = Math.abs(-a[i] * -b[i]) + Math.abs(-a[i] * -c[i]) + Math.abs(-b[i] * -c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8016().sumReductionImplement(a, b, c, d, total));
    }
}
