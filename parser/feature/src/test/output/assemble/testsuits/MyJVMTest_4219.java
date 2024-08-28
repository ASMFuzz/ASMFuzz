public class MyJVMTest_4219 {

    static float[] a = { Float.NaN, Float.POSITIVE_INFINITY, 0.2753628f, 0.9832357f, Float.NEGATIVE_INFINITY, 0.55593944f, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN };

    float summ2(float[] a) {
        Float result1 = 1.f;
        Float result2 = new Float(1.f);
        for (Float i : a) {
            result1 += i;
            result2 += new Float(i + 1.f);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4219().summ2(a));
    }
}
