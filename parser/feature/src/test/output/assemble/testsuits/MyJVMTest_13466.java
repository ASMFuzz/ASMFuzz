public class MyJVMTest_13466 {

    static float[] a = { Float.MAX_VALUE, 0.68812895f, 0.4849751f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

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
        System.out.println(new MyJVMTest_13466().sumc2(a));
    }
}
