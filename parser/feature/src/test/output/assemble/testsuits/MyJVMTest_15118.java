public class MyJVMTest_15118 {

    static float[] a = { Float.MIN_VALUE, 0f, 0f, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.3946141f, 0.19414955f, 0f };

    float sumb(float[] a) {
        Float result = 1.f;
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15118().sumb(a));
    }
}
