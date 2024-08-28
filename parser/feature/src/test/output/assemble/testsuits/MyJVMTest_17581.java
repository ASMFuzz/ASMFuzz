public class MyJVMTest_17581 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    float sum(float[] a) {
        float result = 1.f;
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17581().sum(a));
    }
}
