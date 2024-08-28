public class MyJVMTest_17791 {

    static float[] c1 = { Float.NaN, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.30157357f, Float.NEGATIVE_INFINITY, 0.123713076f, Float.POSITIVE_INFINITY };

    static float[] c2 = { Float.NEGATIVE_INFINITY, 0.7368003f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.21335703f, Float.MIN_VALUE, Float.MIN_VALUE, 0f };

    static float[] c3 = { Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, 0.61086935f, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE };

    float prodFloat(float[] c1, float[] c2, float[] c3) {
        float total = 1;
        for (int i = 0; i < c1.length; i++) {
            total *= (c1[i] * c2[i]) + (c1[i] * c3[i]) + (c2[i] * c3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17791().prodFloat(c1, c2, c3));
    }
}
