public class MyJVMTest_4953 {

    static float[] a0 = { Float.MIN_VALUE, 0.8724446f, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static float[] a1 = { Float.MAX_VALUE, 0.37095606f, Float.MAX_VALUE, 0.60708547f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.55747145f, Float.NEGATIVE_INFINITY, Float.NaN };

    float[] test_addi(float[] a0, float[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] + (float) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4953().test_addi(a0, a1);
    }
}
