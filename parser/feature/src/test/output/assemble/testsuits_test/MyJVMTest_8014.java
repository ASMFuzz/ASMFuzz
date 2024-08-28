public class MyJVMTest_8014 {

    static float[] a = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NaN, 0f };

    float sum(float[] a) {
        float result = 1.f;
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8014().sum(a));
    }
}
