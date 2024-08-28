public class MyJVMTest_5805 {

    static float[] a = { 0f, 0.9593745f, Float.MAX_VALUE, Float.MAX_VALUE, 0f, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    float sumb2(float[] a) {
        Float result1 = 1.f;
        Float result2 = 1.f;
        for (Float i : a) {
            result1 += i;
            result2 += i + 1.f;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5805().sumb2(a));
    }
}
