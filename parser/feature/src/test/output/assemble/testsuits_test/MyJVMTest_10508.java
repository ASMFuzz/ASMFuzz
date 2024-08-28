public class MyJVMTest_10508 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0.8229489f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f };

    static double[] b = { Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, 0.7616915096381869, 0.05191243072218432, 0.6769597969932958, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    float[] test_ci(float[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10508().test_ci(a, b);
    }
}
