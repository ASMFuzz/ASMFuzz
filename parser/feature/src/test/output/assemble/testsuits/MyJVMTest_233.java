public class MyJVMTest_233 {

    static float[] a = { Float.MIN_VALUE, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.19375324f, Float.MIN_VALUE, 0.23851144f, Float.MAX_VALUE, Float.MAX_VALUE, 0.21325779f };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float total = Float.NaN;

    float prodReductionImplement(float[] a, float[] b, float total) {
        for (int i = 0; i < a.length; i++) {
            total *= a[i] - b[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_233().prodReductionImplement(a, b, total));
    }
}
