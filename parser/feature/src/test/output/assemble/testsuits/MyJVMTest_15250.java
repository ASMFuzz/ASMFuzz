public class MyJVMTest_15250 {

    static float[] a = { 0.80822057f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

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
        System.out.println(new MyJVMTest_15250().sumb2(a));
    }
}
