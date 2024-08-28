public class MyJVMTest_5437 {

    static long[] a = { 0, -4040078858037571313L, 9223372036854775807L, -9223372036854775808L, 5700553493510772845L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static double[] b = { Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0.4731787927634209, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.MIN_VALUE, Double.NaN };

    static long c = 0;

    static double d = Double.MIN_VALUE;

    static int ALIGN_OFF = 8;

    long[] test_vi_aln(long[] a, double[] b, long c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5437().test_vi_aln(a, b, c, d);
    }
}
