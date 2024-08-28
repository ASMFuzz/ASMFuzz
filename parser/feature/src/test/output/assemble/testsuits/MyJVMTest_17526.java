public class MyJVMTest_17526 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, 0.04147786f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static Float result = Float.NEGATIVE_INFINITY;

    float sump(float[] a, Float result) {
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17526().sump(a, result));
    }
}
