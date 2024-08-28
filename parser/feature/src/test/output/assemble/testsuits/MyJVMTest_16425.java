public class MyJVMTest_16425 {

    static float[] a = { Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY };

    static Float ibc = new Float(1.f);

    float sumc(float[] a) {
        Float result = ibc;
        for (Float i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16425().sumc(a));
    }
}
