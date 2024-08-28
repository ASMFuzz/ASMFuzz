public class MyJVMTest_7962 {

    static float[] a = { Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, 0.5052479f, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.4503495f };

    static Float result = 0.10274321f;

    float sump(float[] a, Float result) {
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7962().sump(a, result));
    }
}
