public class MyJVMTest_15518 {

    static float[] a = { 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, 0.08981943f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f };

    static double[] b = { 0.5219406775405265, 0d, 0.205837356353887, 0.8345728908592215, 0.7587219319592486, Double.NEGATIVE_INFINITY, 0.7352763963318468, Double.NaN, 0.11886621960968413, 0d };

    static float c = 0.9328026f;

    static double d = Double.MIN_VALUE;

    float[] test_vi(float[] a, double[] b, float c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15518().test_vi(a, b, c, d);
    }
}
