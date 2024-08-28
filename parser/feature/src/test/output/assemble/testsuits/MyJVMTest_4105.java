public class MyJVMTest_4105 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.40621918f, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, 0.7020505f };

    static Float ibc = new Float(1.f);

    float sumc2(float[] a) {
        Float result1 = 1.f;
        Float result2 = ibc;
        for (Float i : a) {
            result1 += i;
            result2 += i + ibc;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4105().sumc2(a));
    }
}
