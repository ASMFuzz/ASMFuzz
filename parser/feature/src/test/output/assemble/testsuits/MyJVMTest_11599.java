public class MyJVMTest_11599 {

    static float[] a = { Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.63181823f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, 0.70963854f };

    static Float result2 = Float.POSITIVE_INFINITY;

    float sump2(float[] a, Float result2) {
        Float result1 = 1.f;
        for (Float i : a) {
            result1 += i;
            result2 += i + 1.f;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11599().sump2(a, result2));
    }
}
