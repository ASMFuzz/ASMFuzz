public class MyJVMTest_16524 {

    static int[] a = { 0, 0, 0, 3, -1842599706, 8, 0, 803031991, 0, 8 };

    static double[] b = { Double.NaN, 0.18479354739829834, 0.04308237340122556, Double.MIN_VALUE, 0d, 0.0029842049461937803, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, 0d };

    static int c = 866599457;

    static double d = 0.7268596081978781;

    static int ALIGN_OFF = 8;

    int[] test_vi_aln(int[] a, double[] b, int c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16524().test_vi_aln(a, b, c, d);
    }
}
