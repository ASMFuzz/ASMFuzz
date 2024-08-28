public class MyJVMTest_9384 {

    static float[] a = { Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, 0.65199256f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static float[] b = { 0f, Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, 0f, Float.MIN_VALUE, 0.29588443f, Float.MIN_VALUE };

    static float total = Float.MIN_VALUE;

    float prodReductionImplement(float[] a, float[] b, float total) {
        for (int i = 0; i < a.length; i++) {
            total *= a[i] - b[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9384().prodReductionImplement(a, b, total));
    }
}
