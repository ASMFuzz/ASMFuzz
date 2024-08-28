public class MyJVMTest_2122 {

    static float[] a = { Float.MIN_VALUE, 0f, Float.NaN, Float.MIN_VALUE, 0.97778f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, 0f };

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
        System.out.println(new MyJVMTest_2122().sum2(a));
    }
}
