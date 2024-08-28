public class MyJVMTest_16209 {

    static int[] a = { 1, 1489447163, 877427633, 0, 0, 4, -376417027, 4, 6, 0 };

    static int[] b = { 5, -153448061, 0, 6, 0, 2146125460, 7, 0, 7, -1895097538 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, 0.3665074607560249, 0.4859952212556251, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0.5844480957197197, Double.NaN };

    static double[] d = { 0d, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16209().test_cp_unalnsrc(a, b, c, d);
    }
}
