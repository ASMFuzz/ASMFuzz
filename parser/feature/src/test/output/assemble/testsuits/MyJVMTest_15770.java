public class MyJVMTest_15770 {

    static float[] a = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN };

    static float[] b = { Float.MAX_VALUE, Float.MAX_VALUE, 0f, 0.77344805f, 0.43207318f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static double[] c = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, 0d, 0d, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    static double[] d = { Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.03690429532332329, 0d, 0.7105084475622162, Double.NaN, 0d, 0.31309962801657676, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_cp_alnsrc(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15770().test_cp_alnsrc(a, b, c, d);
    }
}
