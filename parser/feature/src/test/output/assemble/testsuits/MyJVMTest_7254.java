public class MyJVMTest_7254 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0.56631845f, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, Float.MIN_VALUE };

    static double[] c = { 0d, 0.01665948944735607, Double.MAX_VALUE, 0.6932751246568792, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, 0.624551683832109, 0.0428425366009606, Double.MIN_VALUE };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.7330561874436847 };

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
        new MyJVMTest_7254().test_cp_unalnsrc(a, b, c, d);
    }
}
