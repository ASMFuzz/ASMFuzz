public class MyJVMTest_6915 {

    static float[] a = { 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static Float ibc = new Float(1.f);

    float sumc(float[] a) {
        Float result = ibc;
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6915().sumc(a));
    }
}
