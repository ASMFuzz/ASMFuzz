public class MyJVMTest_16777 {

    static float[] a = { Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, 0.90231806f, 0.20323533f, 0.12912214f, Float.NaN, Float.POSITIVE_INFINITY, 0f, 0.10304886f };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0f, 0.573322f, Float.MAX_VALUE, 0.2677402f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static double[] c = { 0.43721773907856754, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0.7910353154783021, 0.8526414729107434, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { 0.7370115092817605, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.6895143427945075, Double.MAX_VALUE, 0.961808284348659, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_cp_unalnsrc(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16777().test_cp_unalnsrc(a, b, c, d);
    }
}
