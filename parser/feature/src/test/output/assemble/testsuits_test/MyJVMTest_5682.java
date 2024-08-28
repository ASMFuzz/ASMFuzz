public class MyJVMTest_5682 {

    static float[] a = { Float.NaN, Float.MAX_VALUE, 0f, 0.37704808f, 0.9402208f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    float sumb(float[] a) {
        Float result = 1.f;
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5682().sumb(a));
    }
}
