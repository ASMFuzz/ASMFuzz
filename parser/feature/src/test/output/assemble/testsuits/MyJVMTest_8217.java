public class MyJVMTest_8217 {

    static float[] c1 = { 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] c2 = { Float.MIN_VALUE, 0.92540675f, 0.7550733f, Float.POSITIVE_INFINITY, 0.24845904f, Float.MAX_VALUE, 0.49303114f, Float.MAX_VALUE, Float.MIN_VALUE, 0.03223765f };

    static float[] c3 = { Float.POSITIVE_INFINITY, 0.97747046f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY };

    float prodFloat(float[] c1, float[] c2, float[] c3) {
        float total = 1;
        for (int i = 0; i < c1.length; i++) {
            total *= (c1[i] * c2[i]) + (c1[i] * c3[i]) + (c2[i] * c3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8217().prodFloat(c1, c2, c3));
    }
}
