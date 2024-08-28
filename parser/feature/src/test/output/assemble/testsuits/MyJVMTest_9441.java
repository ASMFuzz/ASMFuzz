public class MyJVMTest_9441 {

    static float[] a = { Float.NaN, 0f, Float.NaN, 0f, Float.NaN, Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NaN, Float.NaN, 0f, 0.30730933f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, 0f };

    static float[] c = { 0.14573598f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float[] d = { Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, 0.93647265f, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.33558685f, Float.NEGATIVE_INFINITY };

    static float total = Float.POSITIVE_INFINITY;

    float sumReductionImplement(float[] a, float[] b, float[] c, float[] d, float total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9441().sumReductionImplement(a, b, c, d, total));
    }
}
