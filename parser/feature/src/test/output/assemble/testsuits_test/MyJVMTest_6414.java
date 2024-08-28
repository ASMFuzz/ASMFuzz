public class MyJVMTest_6414 {

    static float[] c1 = { 0f, 0.39616382f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0f };

    static float[] c2 = { Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0.9711967f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    static float[] c3 = { 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, 0f, 0f, Float.POSITIVE_INFINITY, 0.12225902f, Float.NEGATIVE_INFINITY };

    float sumFloat(float[] c1, float[] c2, float[] c3) {
        float total = 0;
        for (int i = 0; i < c1.length; i++) {
            total += (c1[i] * c2[i]) + (c1[i] * c3[i]) + (c2[i] * c3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6414().sumFloat(c1, c2, c3));
    }
}
