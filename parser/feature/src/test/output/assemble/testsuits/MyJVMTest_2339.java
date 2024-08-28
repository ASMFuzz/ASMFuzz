public class MyJVMTest_2339 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, 0f, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static Float result2 = Float.NEGATIVE_INFINITY;

    float sump2(float[] a, Float result2) {
        Float result1 = 1.f;
        for (Float i : a) {
            result1 += i;
            result2 += i + 1.f;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2339().sump2(a, result2));
    }
}
