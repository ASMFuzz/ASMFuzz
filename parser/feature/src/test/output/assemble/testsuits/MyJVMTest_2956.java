public class MyJVMTest_2956 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NaN, 0f, Float.POSITIVE_INFINITY };

    static double[] b = { 0d, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.5915361653385696, Double.NEGATIVE_INFINITY, 0.05760653306795027 };

    static float c = 0.5696957f;

    static double d = Double.NaN;

    static int ALIGN_OFF = 8;

    float[] test_vi_aln(float[] a, double[] b, float c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2956().test_vi_aln(a, b, c, d);
    }
}
