public class MyJVMTest_13583 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

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
        System.out.println(new MyJVMTest_13583().summ2(a));
    }
}
