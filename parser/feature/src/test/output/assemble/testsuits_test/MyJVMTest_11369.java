public class MyJVMTest_11369 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0f, 0.9878293f, 0.02037704f, 0.27797467f, Float.POSITIVE_INFINITY, 0f };

    float sum2(float[] a) {
        float result1 = 1.f;
        float result2 = 1.f;
        for (Float i : a) {
            result1 += i;
            result2 += i + 1.f;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11369().sum2(a));
    }
}
