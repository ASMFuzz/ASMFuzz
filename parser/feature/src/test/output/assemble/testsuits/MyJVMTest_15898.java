public class MyJVMTest_15898 {

    static float[] c1 = { Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0f, 0f, 0.33534145f, 0.11143643f, 0.8451121f };

    static float[] c2 = { 0f, Float.MAX_VALUE, 0.020754457f, 0.885818f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0f };

    static float[] c3 = { 0.5031616f, Float.POSITIVE_INFINITY, 0.582713f, Float.MIN_VALUE, 0f, 0.50959355f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f };

    float sumFloat(float[] c1, float[] c2, float[] c3) {
        float total = 0;
        for (int i = 0; i < c1.length; i++) {
            total += (c1[i] * c2[i]) + (c1[i] * c3[i]) + (c2[i] * c3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15898().sumFloat(c1, c2, c3));
    }
}
