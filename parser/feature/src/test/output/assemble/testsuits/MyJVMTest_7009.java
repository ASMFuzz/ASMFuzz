public class MyJVMTest_7009 {

    static int[] a = { 3, 7, 8, 1, 967389084, 9, 8, 0, 9, 0 };

    static double[] b = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.047422304360056566, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0d };

    static int c = 0;

    static double d = Double.NaN;

    static int ALIGN_OFF = 8;

    int[] test_vi_aln(int[] a, double[] b, int c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7009().test_vi_aln(a, b, c, d);
    }
}
