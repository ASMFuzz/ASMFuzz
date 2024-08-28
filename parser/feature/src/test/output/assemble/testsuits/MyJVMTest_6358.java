public class MyJVMTest_6358 {

    static int[] a = { 8, 830266345, 2, 0, 0, 0, 8, 1, 301087427, 5 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0.2329641101935087, 0.17122413995445684, Double.NaN, 0d, Double.POSITIVE_INFINITY, 0.8720402128085212, 0.6831209921201775 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_ci_unaln(int[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6358().test_ci_unaln(a, b);
    }
}
